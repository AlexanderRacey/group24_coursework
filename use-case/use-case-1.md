# USE CASE: 1 Produce a Report on Countries: Worldwide, Continental or Regional

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Analyst* I want to *view all countries worldwide, continental or regional, in descending order based on their population* so that *I can easily inspect population trends*.

### Scope

Company.

### Level

Primary task.

### Preconditions

Region selection.  
Database contains the data.

### Success End Condition

A report is available for the Analyst to inspect.

### Failed End Condition

No report is produced.

### Primary Actor

Company's Analyst.

### Trigger

A request for world information is sent to the Information Department.

## MAIN SUCCESS SCENARIO

1. Countries report request for a given region.
2. Analyst captures region to get the information for.
4. Analyst reports the information.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.1

## DIAGRAM

![UC1](use-case-diagrams/use-case-1.png)