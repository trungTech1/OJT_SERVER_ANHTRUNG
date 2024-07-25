package com.example.shop_sv.modules.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.example.shop_sv.modules.enums.RoleNameEnum;
import com.example.shop_sv.modules.role.UserRole;
import com.example.shop_sv.modules.user.UserModel;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.lang.reflect.Field;
import java.util.Date;

@Service
public class JwtService {

    private static final String secretKey = "thienpxc";

    public static String createTokenUser(UserModel data) throws IllegalAccessException {
        JWTCreator.Builder builder = JWT.create().withIssuer("auth0");

        long oneHourInMillis = 3600 * 1000 * 48;
        Date expirationTime = new Date(System.currentTimeMillis() + oneHourInMillis);
        builder.withExpiresAt(expirationTime);

        Field[] fields = UserModel.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(data);
            if (value != null) {
                builder.withClaim(field.getName(), value.toString());
            }
        }

        return builder.sign(Algorithm.HMAC256(secretKey));
    }

    public static UserModel verifyTokenUser(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build()
                    .verify(token);

            UserModel user = new UserModel();

            Integer id = Integer.parseInt(jwt.getClaim("id").asString());
            user.setId(id);

            String username = jwt.getClaim("username").asString();
            user.setUsername(username);

            String email = jwt.getClaim("email").asString();
            user.setEmail(email);

            String phone = jwt.getClaim("phone").asString();
            user.setPhone(phone);

            String full_name = jwt.getClaim("full_name").asString();
            user.setFull_name(full_name);

            String role = jwt.getClaim("role").asString();

//            RoleNameEnum roleName = RoleNameEnum.valueOf(role);
//            user.setRoles(roleName);

            String permission = jwt.getClaim("permission").asString();
            user.setPermission(permission);

            String avatar = jwt.getClaim("avatar").asString();
            user.setAvatar(avatar);

            Boolean status = Boolean.valueOf(jwt.getClaim("status").asString());
            user.setStatus(status);

            Boolean isDeleted = Boolean.valueOf(jwt.getClaim("is_deleted").asString());
            user.setIs_deleted(isDeleted);

            Boolean isVerified = Boolean.valueOf(jwt.getClaim("isVerified").asString());
            user.setVerified(isVerified);

            String createAt = jwt.getClaim("created_at").asString();
            user.setCreated_at(createAt);

            String updateAt = jwt.getClaim("updated_at").asString();
            user.setUpdated_at(updateAt);

            return user;
        } catch (JWTVerificationException exception){
            return null;
        }
    }
}
