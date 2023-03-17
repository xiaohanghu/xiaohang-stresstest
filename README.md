### This is a Java stress test tool.

```
StressTestUtils.testAndPrint(100, 1000, new StressTask() {

            @Override
            public Object doTask() throws Exception {
                System.out.println("Do my task.");
                return null;
            }
        }, "Demo");
```

Output:
```
Demo test result:
Concurrency Level:	100
Time taken for tests:	5.015543 ms
Complete Tasks:	1000
Failed Tasks:		0
Tasks per second:	521916.03
Time per task:		0.19160171 ms
Time per task:		0.001916017 ms (across all concurrent tasks)
Shortest task:		0.001042 ms
Percentage of the tasks served within a certain time (ms)
50%	0.003875
66%	0.006375
75%	0.011708
80%	0.013625
90%	0.065458
95%	1.59475
98%	3.581417
99%	3.965375
100%	4.9335 (longest task)
```