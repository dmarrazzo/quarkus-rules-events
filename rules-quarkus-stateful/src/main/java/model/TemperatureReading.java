package model;

import java.time.LocalDateTime;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;
import org.kie.api.definition.type.Role.Type;

@Role(Type.EVENT)
@Timestamp("readingDateTime")
public class TemperatureReading {
    
    private Double temperature;
    private LocalDateTime readingDateTime;
    
    @Override
    public String toString() {
        return String.format("TemperatureReading {readingDateTime: %s, temperature: %s }", readingDateTime,
                temperature);
    }

    // GETTERS / SETTERS -----------------------------------------------------------------

    /**
     * @return the temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the readingDateTime
     */
    public LocalDateTime getReadingDateTime() {
        return readingDateTime;
    }

    /**
     * @param readingDateTime the readingDateTime to set
     */
    public void setReadingDateTime(LocalDateTime readingDateTime) {
        this.readingDateTime = readingDateTime;
    }
}