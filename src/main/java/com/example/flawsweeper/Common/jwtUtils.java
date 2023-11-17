package com.example.flawsweeper.Common;

import com.example.flawsweeper.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class jwtUtils {
    private static long expire = 1000*24*60*60*100;//设置token时间为100天
    private static String secret = "abcdcefg";//密钥


    //生成token

    public static String generateToken(String uid){
        Date now =new Date();
        Date expiration =  new Date(now.getTime()+ expire);
        System.out.println("expiration:"+expiration);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(uid)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    //解析token
    public static Claims getClaimsByToken(String token){
        System.out.println("token："+token);
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}