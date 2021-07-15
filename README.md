
# DSL for calculation with java
--------------------------------------
this repo is a side project example for DSL (domain specific language ) in java ,
for simple calculator generator app


## Syntax
-----------------------
```
field :  required for add input from the users will be float
ex : (field:salary)
```

```
equation : make operations on fields and previous equations
ex (equation:overTimeTotal=overTimeHours multiply overTimeHourRate)
available operations
- add
- sub
- multiply
- divide
```

```
display : for run equation and print the  result for the user
ex (display:netSalary)

```
## Example

```
field:salary
field:bounce
field:overTimeHours
field:overTimeHourRate
field:tax
equation:totalWithBounce=salary add bounce
equation:overTimeTotal=overTimeHours multiply overTimeHourRate
equation:growthSalary=totalWithBounce add overTimeTotal
equation:netSalary=growthSalary sub tax
display:netSalary
```

## TODOS
---------------------
- allow comments
- allow spaces
- allow to make equations with more than 2 elements
