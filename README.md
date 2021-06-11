# CrossCountryRace
In a cross-country race, teams (very minimally represented by the Team class in the race package ) are assigned an identifier (ID) during registration, which they use to sign in and out at the start and finish.
Start and finish times (in seconds after the oﬀicial start) are then noted for each runner to calculate the times the runners took to complete the course.

The timekeeping class is intended to map these functions:
- The method register(String teamId, Team team) stores the connection between team and identifier
- The method start(String teamId, long startTime) stores the start time
- The method finish(String teamId, long stopTime) stores the finish time
- The getTime(String teamId) method returns the difference between the target and start time for each identifier for which a target time is available
- ThegetWaiting(),getRunning()andgetFinished()methods return theTeams(objects of type Team), which are registered but not started (getWaiting()), started but not finished (getRunning()) or finished (getFinished()).
- The getFinished() method returns the teams (again objects of type Team ) with a mapping to the time.

