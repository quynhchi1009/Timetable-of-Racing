package edu.hm.cs.bka.dev2.rennen;

import java.util.*;

/**
 * Klasse zum Registrieren von Teams und deren Zeiterfassung.
 */
public class Zeitnahme {
  HashMap<String, Team> registeredTeam = new HashMap<>();
  HashMap<String, Long> startedTime = new HashMap<>();
  HashMap<String, Long> endedTime = new HashMap<>();

  /**
   * Registriert ein Team unter einer Team-Kennung.
   *
   * @param teamId Kennung
   * @param team   Läufer
   */
  public void register(String teamId, Team team) {
    // TODO: Implementierung ergänzen
    if (!registeredTeam.containsKey(teamId)) {
      if (!registeredTeam.containsValue(team)) {
        registeredTeam.put(teamId, team);
      }
    }
  }

  /**
   * Speichert die Startzeit eines Teams.
   *
   * @param teamId    Kennung
   * @param startTime Startzeit (nach Beginn des Rennens)
   */
  public void start(String teamId, long startTime)  {
    // TODO: Implementierung ergänzen
    if (!registeredTeam.containsKey(teamId)) {
      //wenn die Kennung nicht registriert ist
      throw new RuntimeException("There is no Team with this ID.");
    } else if (startedTime.get(teamId) != null) {
      //wenn bereits eine Startzeit hinterlegt ist.
      throw new RuntimeException("There is already started time for this ID Team.");
    } else {
      startedTime.put(teamId, startTime);
    }
  }

  /**
   * Speichert die Zielzeit eines Läufers.
   *
   * @param teamId Kennung
   * @param stopTime Zielzeit (ab Beginn des Rennens)
   */
  public void finish(String teamId, long stopTime)  {
    // TODO: Implementierung ergänzen
    if (!registeredTeam.containsKey(teamId)) {
      ///wenn die Kennung nicht registriert ist
      throw new RuntimeException("There is no Team with this ID.");
    } else if (startedTime.get(teamId) == null) {
      //wenn keine Startzeit hinterlegt ist
      throw new RuntimeException("There is not started time for this ID Team");
    } else if (endedTime.get(teamId) != null) {
      //wenn bereits eine Zielzeit hinterlegt ist
      throw new RuntimeException("There is already ended time for this ID Team");
    } else {
      endedTime.put(teamId, stopTime);
    }
  }

  /**
   * Liefert eine Collection mit allen Teams, die registriert, aber nicht gestartet sind.
   *
   * @return registrierte, nicht gestartete Teams
   */
  public Collection<Team> getWaiting() {
    // TODO: Implementierung ergänzen
    Collection<Team> result = new ArrayList<>();
    //liefert die Menge aller angemeldeten Teilnehmer K zurück
    for (String id : registeredTeam.keySet()) {
      // Getting values from HashMap
      Team t = registeredTeam.get(id);
      result.add(t);
    }
    //loeschen die Menge aller noch nicht gestarteten K zurück
    for (String id : startedTime.keySet()) {
      // Getting values from HashMap
      Team t = registeredTeam.get(id);
      result.remove(t);
    }
    return result;
  }

  /**
   * Liefert eine Collection mit allen Teams, die gestartet, aber nicht im Ziel sind.
   *
   * @return laufende Teams
   */
  public Collection<Team> getRunning() {
    // TODO: Implementierung ergänzen
    Collection<Team> tresult = new ArrayList<>();
    //liefert die Menge aller gestarteten Teilnehmer K zurück
    for (String id : startedTime.keySet()) {
      // Getting values from HashMap
      Team t = registeredTeam.get(id);
      tresult.add(t);
    }
    //loeschen die Menge aller K, die noch nicht am Ende sind, zurück
    for (String id : endedTime.keySet()) {
      // Getting values from HashMap
      Team t = registeredTeam.get(id);
      tresult.remove(t);
    }
    return tresult;
  }

  /**
   * Liefert die Gesamtzeit eines Läufers.
   *
   * @param teamId Kennung
   * @return Differenz aus Zielzeit und Startzeit
   */
  public long getTime(String teamId) {
    // TODO: Implementierung ergänzen
    if (!registeredTeam.containsKey(teamId)) {
      ///wenn die Kennung nicht registriert ist
      throw new RuntimeException("There is no Team with this ID.");
    } else if (startedTime.get(teamId) == null) {
      //wenn keine Startzeit hinterlegt ist
      throw new RuntimeException("There is not started time for this ID Team");
    } else if (endedTime.get(teamId) == null) {
      //wenn bereits eine Zielzeit hinterlegt ist
      throw new RuntimeException("There is already ended time for this ID Team");
    } else {
      long start = startedTime.get(teamId);
      long end = endedTime.get(teamId);
      return end - start;
    }
  }

  /**
   * Liefert eine Map, die Teams, die schon im Ziel sind, auf ihre Zielzeit abbildet.
   *
   * @return Abbildung Teams-Gesamtzeit
   */
  public Map<Team, Long> getFinished() {
    // TODO: Implementierung ergänzen
    Map<Team, Long> result = new HashMap<>();
    //liefert die Menge aller fertigen Teilnehmer K zurück
    for (String id : endedTime.keySet()) {
      // Getting values from HashMap
      Team t = registeredTeam.get(id);
      result.put(t, getTime(id));
    }
    return result;
  }

}
