package util;

import com.csr.core.objects.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;


/**
 * Plain Java Basic JWT Impl
 * @author Jayesh
 */
public class JwtUtil {


    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 1000L; //Setting 24 hours for now
    private static final String[] PUBLIC_CLAIMS = {"iss", "sub", "exp", "iat", "jti"}; //Only adding these for now
    private static final String ISSUER = "com.lti";
    private static final String HEADER = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
    private static final String SECRET = "0562984534";

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private JwtUtil() {
        throw new IllegalStateException("Util class");
    }

    /**
     * @param user user object from login
     * @return
     */
    public static String generateJWT(User user) {
        String encodedHeader = encode(HEADER);
        String encodedPayload;
        String signature;
        JsonObject payload = new JsonObject();

        payload.addProperty(PUBLIC_CLAIMS[0], ISSUER);
        payload.addProperty(PUBLIC_CLAIMS[1], user.getUserName());
        payload.addProperty(PUBLIC_CLAIMS[2], (System.currentTimeMillis() + JWT_TOKEN_VALIDITY) / 1000);
        payload.addProperty(PUBLIC_CLAIMS[3], System.currentTimeMillis() / 1000);
        payload.addProperty(PUBLIC_CLAIMS[4], UUID.randomUUID().toString());

        encodedPayload = encode(payload.toString());
        signature = signWithHMAC(encodedHeader + "." + encodedPayload, SECRET);

        return encodedHeader + "." + encodedPayload + "." + signature;
    }


    /**
     * Utility method to encode in base64url
     *
     * @param data
     * @return
     */
    private static String encode(String data) {
        return Base64.getUrlEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Utility method to decode in base64url
     *
     * @param data
     * @return
     */
    private static String decode(String data) {
        return new String(Base64.getUrlDecoder().decode(data));
    }


    /**
     * Signs input with specified secret and HmacSHA256 algorithm
     *
     * @param data
     * @param secret
     * @return
     */
    private static String signWithHMAC(String data, String secret) {
        try {
            byte[] secretBytes = secret.getBytes(StandardCharsets.UTF_8);

            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretBytes, "HmacSHA256");
            sha256Hmac.init(secretKeySpec);

            byte[] signedBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            return encode(Arrays.toString(signedBytes));

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            logger.error("NoSuchAlgorithmException {}", e.getMessage());
            e.printStackTrace();
        }
        return null;

    }


    /**
     * Method only checks if token format is valid <strong>DOES NOT</strong> check for expiry
     *
     * @param token
     * @return
     */
    public static boolean isTokenValid(String token) {
        logger.info("Checking JWT");

        if (token == null || token.isEmpty()) {
            logger.error("Got Null | Blank token");
            return false;
        }

        String[] parts = token.split("\\."); //escaping dot for regex

        if (parts.length < 3) {
            logger.error("JWT format incorrect");
            return false;
        } else {
            if (!encode(HEADER).equals(parts[0])) {
                logger.error("JWT Header is incorrect");
                return false;
            } else {
                //Token format and header is correct checking for payload

                if (parts[1].isEmpty()) {
                    logger.error("Payload is Empty");
                    return false;
                }

                String payloadString = decode(parts[1]);

                JsonObject extractedPayload = new JsonParser().parse(payloadString).getAsJsonObject();

                for (String claim : PUBLIC_CLAIMS) {
                    if (!extractedPayload.has(claim)) {
                        logger.error("Malformed payload in JWT");
                        return false;
                    }
                }
                //Payload is also fine with all claims
                return true;
            }
        }
    }

    /**
     * Returns specified claim in string format
     *
     * @param claim
     * @param token
     * @return
     */
    private static String extractClaim(String claim, String token) {

        if (isTokenValid(token)) {
            String payloadString = token.split("\\.")[1];
            JsonObject extractedPayload = new JsonParser().parse(decode(payloadString)).getAsJsonObject();
            return extractedPayload.get(claim).getAsString();
        } else {
            logger.error("Malformed token in extractClaim");
            throw new IllegalArgumentException("Malformed token in extractClaim");
        }

    }

    public static boolean isTokenExpired(String token) {
        if (isTokenValid(token)) {

            long expiration = Long.parseLong(extractClaim("exp", token));

            return (System.currentTimeMillis() > (expiration * 1000));

        } else {
            logger.error("Token malformed");
            return false;
        }
    }

    public static String getUserNameFromToken(String token) {
        return extractClaim("sub", token);
    }

}
