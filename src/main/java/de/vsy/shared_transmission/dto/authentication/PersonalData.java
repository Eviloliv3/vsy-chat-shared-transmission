package de.vsy.shared_transmission.dto.authentication;

import static java.util.Objects.hash;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/***/
@JsonTypeName("personalData")
public class PersonalData implements Serializable {

  @Serial
  private static final long serialVersionUID = -4605010330930942456L;
  private final String firstName;
  private final String lastName;

  private PersonalData(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @param firstName the firstName
   * @param lastName  the lastName
   * @return the PersonalData created from given arguments
   */
  @JsonCreator
  public static PersonalData valueOf(@JsonProperty("firstName") final String firstName,
      @JsonProperty("lastName") final String lastName) {
    if (firstName == null) {
      throw new IllegalArgumentException("No first name specified..");
    }
    if (lastName == null) {
      throw new IllegalArgumentException("No last name specified.");
    }
    return new PersonalData(firstName, lastName);
  }

  /**
   * @return the firstName
   */
  public String getForename() {
    return this.firstName;
  }

  /**
   * @return the lastName
   */
  public String getSurname() {
    return this.lastName;
  }

  @Override
  public int hashCode() {
    return hash(this.firstName, this.lastName);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }

    if (!(otherObject instanceof PersonalData that)) {
      return false;
    }
    return Objects.equals(this.firstName, that.firstName) && Objects.equals(this.lastName,
        that.lastName);
  }

  @Override
  public String toString() {
    return "\"personalData\": { \"firstName\": \"" + this.firstName + "\", " + "\"lastName\": \""
        + this.lastName
        + "\" }";
  }
}
