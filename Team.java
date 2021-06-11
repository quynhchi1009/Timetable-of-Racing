package edu.hm.cs.bka.dev2.rennen;

import java.util.Objects;

/**
 * Repräsentation eines/r Teilnehmer:in.
 */
public class Team {

  private final String name;

  public Team(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Team " + name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Team other = (Team) obj;
    return Objects.equals(name, other.name);
  }

}
