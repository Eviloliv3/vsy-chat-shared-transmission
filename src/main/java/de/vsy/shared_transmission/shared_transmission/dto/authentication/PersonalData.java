package de.vsy.shared_transmission.shared_transmission.dto.authentication;

import static java.util.Objects.hash;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author fredward
 */
@JsonTypeName("personalData")
public class PersonalData implements Serializable {

  @Serial
  private static final long serialVersionUID = -4605010330930942456L;
  private final String forename;
  private final String surname;

  private PersonalData(final String forename, final String surname) {
    this.forename = forename;
    this.surname = surname;
  }

  /**
   * @param forename the forename
   * @param surname  the surname
   * @return the PersonalData created from given arguments
   */
  @JsonCreator
  public static PersonalData valueOf(@JsonProperty("forename") final String forename,
      @JsonProperty("surname") final String surname) {
    if (forename == null) {
      throw new IllegalArgumentException("Kein Vorname angegeben.");
    }
    if (surname == null) {
      throw new IllegalArgumentException("Kein Nachname angegeben.");
    }
    return new PersonalData(forename, surname);
  }

  /**
   * @return the forename
   */
  public String getForename() {
    return this.forename;
  }

  /**
   * @return the surname
   */
  public String getSurname() {
    return this.surname;
  }

  @Override
  public int hashCode() {
    return hash(this.forename, this.surname);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }

    if (!(otherObject instanceof PersonalData that)) {
      return false;
    }
    return Objects.equals(this.forename, that.forename) && Objects.equals(this.surname,
        that.surname);
  }

  @Override
  public String toString() {
    return "\"personalData\": { \"forename\": \"" + this.forename + "\", " + "\"surname\": \""
        + this.surname
        + "\" }";
  }
}
