$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DarkSky.feature");
formatter.feature({
  "line": 3,
  "name": "Verify darksky",
  "description": "",
  "id": "verify-darksky",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.before({
  "duration": 4176105959,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on DarkSkyPage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkyPageSD.verifyHomePage()"
});
formatter.result({
  "duration": 1378134605,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify timeline is displayed in correct format",
  "description": "// When I entered California in search box",
  "id": "verify-darksky;verify-timeline-is-displayed-in-correct-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@timelineformat"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I entered South Lafayette Avenue, Chicago, IL in search box",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I verify timeline is displayed with two hours incremented",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "South Lafayette Avenue, Chicago, IL",
      "offset": 10
    }
  ],
  "location": "DarkSkyPageSD.verifyChosenLocationPage(String)"
});
formatter.result({
  "duration": 1532983497,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkyPageSD.verifyTimeline()"
});
formatter.result({
  "duration": 1936060213,
  "status": "passed"
});
formatter.after({
  "duration": 195308424,
  "status": "passed"
});
formatter.before({
  "duration": 2685417396,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on DarkSkyPage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkyPageSD.verifyHomePage()"
});
formatter.result({
  "duration": 1011056912,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verify individual day temp timeline",
  "description": "",
  "id": "verify-darksky;verify-individual-day-temp-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@temptimeline"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "I expand today\u0027s timeline",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I verify lowest and highest temp is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkyPageSD.expandToday()"
});
formatter.result({
  "duration": 53248983,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkyPageSD.verifyTempValues()"
});
formatter.result({
  "duration": 4200315613,
  "status": "passed"
});
formatter.after({
  "duration": 137631720,
  "status": "passed"
});
});