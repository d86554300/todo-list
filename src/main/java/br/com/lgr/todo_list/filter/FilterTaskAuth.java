package br.com.lgr.todo_list.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.lgr.todo_list.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (request.getServletPath().startsWith("/tasks/")) {
            // Get auth
            var authorization = request.getHeader("Authorization");
            var authEncoded = authorization.substring("Basic".length()).trim();
            System.out.println(authEncoded);
            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
            var authStr = new String(authDecode);
            System.out.println(authStr);

            String[] credentials = authStr.split(":");
            String userName = credentials[0];
            String password = credentials[1];

            System.out.println(userName);
            System.out.println(password);

            var user = this.userRepository.findByUserName(userName);
            if (user == null) {
                response.sendError(401);
            } else {
                var passVerified = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passVerified.verified) {
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
