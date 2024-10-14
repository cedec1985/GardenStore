package gs.java.fs.api.validation.validator;

import gs.java.fs.api.validation.constraints.Username;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<Username, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{0,20}$";
    private static final String[] FORBIDDEN_USERNAMES = {"404", "edit", "me", "admin"};

    @Override
    public void initialize(Username constraintAnnotation) {}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return validateUsername(username);
    }

    private boolean validateUsername(String username) {
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches()
                && !Arrays.asList(FORBIDDEN_USERNAMES).contains(username.toLowerCase());
    }
}
