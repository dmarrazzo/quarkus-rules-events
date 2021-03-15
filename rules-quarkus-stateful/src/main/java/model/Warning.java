package model;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Role.Type;

@Role(Type.EVENT)
public class Warning {
    private String message;

    public Warning() {
    }

    public Warning(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("Warning {message: %s }", message);
    }

    // GETTERS / SETTERS -----------------------------------------------------------------
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}