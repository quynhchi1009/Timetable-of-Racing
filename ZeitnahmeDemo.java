package edu.hm.cs.bka.dev2.rennen;

/**
 * Beispielklasse für Verwendung von TimeKeeper.
 */
public class ZeitnahmeDemo {

  /**
   * Beispielprogramm.
   *
   * @param args wird nicht verwendet
   */
  public static void main(String[] args)  {

    Zeitnahme zeitnahme = new Zeitnahme();

    zeitnahme.register("COOL", new Team("Cool Runnings"));
    zeitnahme.register("IB2B", new Team("HM WiInf 2021"));

    zeitnahme.start("COOL", 320);
    zeitnahme.register("FK07", new Team("FK07 Staff"));
    zeitnahme.register("GOLD", new Team("Go for Gold!"));
    zeitnahme.start("IB2B", 510);
    zeitnahme.finish("COOL", 580);
    zeitnahme.start("GOLD", 600);
    zeitnahme.finish("GOLD", 730);

    // WAITING: [Team FK07 Staff]
    System.out.println("Wartend:  " + zeitnahme.getWaiting());

    // RUNNING: [Team HM WiInf 2021]
    System.out.println("Laufend:  " + zeitnahme.getRunning());

    // FINISHED: {Team Go for Gold!=130, Team Cool Runnings=260}
    System.out.println("Im Ziel: " + zeitnahme.getFinished());
  }
}
