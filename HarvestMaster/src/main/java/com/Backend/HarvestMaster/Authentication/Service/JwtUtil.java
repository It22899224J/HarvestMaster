package com.Backend.HarvestMaster.Authentication.Service;

import com.Backend.HarvestMaster.User.Model.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;





    @Service
    public class JwtUtil {

        @Value("${jwt.secret}")
        private String secret;

        @Value("${jwt.expiration}")
        private long expiration;

        public String generateToken(UserDetails userDetails) {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + expiration);

            return Jwts.builder()
                    .setSubject(userDetails.getEmail()) // Assuming email is unique and used as subject
                    .claim("name", userDetails.getName()) // Adding additional claims if needed
                    // You can add more claims as needed, such as user ID, role, etc.
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
        }
    }
