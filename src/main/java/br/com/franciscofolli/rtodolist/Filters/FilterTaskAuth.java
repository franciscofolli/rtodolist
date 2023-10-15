package br.com.franciscofolli.rtodolist.Filters;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.franciscofolli.rtodolist.Entities.UserEntity;
import br.com.franciscofolli.rtodolist.Repositories.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var servletPath = request.getServletPath();
        if(servletPath.startsWith("/tasks/")){
            // Get username/password
            var auth = request.getHeader("Authorization");
            byte[] decoded =
                    Base64.getDecoder().decode(auth.substring("Basic".length()).trim());
            String authString = new String(decoded);
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // Validate User
            UserEntity user = this.userRepository.findByUsername(username);
            if(user == null){
                response.sendError(401);
            } else {
                // Validate Pass
                var passVerified = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if(passVerified.verified){
                    request.setAttribute("userId", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }


    }
}
