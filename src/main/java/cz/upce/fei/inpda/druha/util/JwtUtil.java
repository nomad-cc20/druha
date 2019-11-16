package cz.upce.fei.inpda.druha.util;

import cz.upce.fei.inpda.druha.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.LinkedHashMap;

public class JwtUtil {

    private final String secret = "ajfn2372nf32bg28prjgergoerjerjojhep5ughrnsoeirgpo34hnpgo34ugoun4poghwp4ougn2p34uhgp984hwpfgw4ohgpw4h8pgo4hpg9whr4p9wuhpg9uw4hpg9w4hpg9hw4p9g8hwp4ghwp4hgpow4ihb3g";

    public long extractUserId(String token) {

        token = token.substring(7);


        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Integer.toUnsignedLong((Integer)((LinkedHashMap)body.get("user")).get("id"));

    }

    public String generateToken(User user) {
        return "Bearer " + Jwts.builder()
                .setSubject(Long.toString(user.getId()))
                .claim("roles", "templates")
                .claim("user", user)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}