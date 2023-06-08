# CSB340_PageReplacement Report
This was a fun project (and like you mentioned) it had a lot in common with the CPU scheduler project, so I
mimicked that project borrowing the structure (and a little of the code). I only wish I had a little more 
time to spend cleaning up my code but c'est la vie. 

For my implementation I was able to correctly calculate fault rates, and I included all the fault counts in my 
console output, but becaue the sizes of the reference strings varied I thought fault rate was a more descriptive
value for analysis (to get a clearer picture of performance), so I also calculated all fault rates per 
algorithm (per configuration) see charts below. I included some of my console output below because every 
time you run my program the results change because of the random numbers. To get a more accurate result I was 
going to run the experiment multiple times and compare an aggregate of the results but I ran out of time. 
Instead I calculated the averages of all algorithms per configuration to compare the different configurations 
against each other. 

As for the results, OPT often prformed the best (but as the book said its unrealistic to actually implement
for paging and is used as a tool for analysis). FIFO and LRU were close and depending on the random 
numbers that were generated sometimes FIFO was better and sometimes LRU was better. I almost expected 
LRU to perform better more of hte time. As far as configurations go, like I said above I used the 
combined average fault rate from all algorithms per configuration to produce one metric I could use 
for comparison. Like the results show below [r:20,f:7] was often the best performing configuration when 
I ran the simulation multiple times. This makes sense intuitivly but counter intuitavly I was expecting 
to see Belady's anomoly come into play more, but if you look at the chart on the top right, and comparing
the groups by reference string size, for each size category it is often the configuration with 7 frames 
that has the smallest fault rate. It also makes sense to me that the best performing configurations 
usually had a larger reference string size because without pre-paging all algorithms start with a 
series of faults and if the size of the reference string is small, those faults add up quick. I wasn't 
sure how big O factors into the results collected for this simulation, for example whether my code ran 
at O(n) or O(n^2) the simulation results should be the same. But if this wasn't a simulation and 
I was actually implementing real page replacement, algorithm performance would have bigger consequences. 



<pre>
Fault Rates:                                      Fault Rate Averages Per Configuration:
------------------------------------              -----------------------------------------------
Config     FIFO     LRU     OPT                   Config Group     FIFO      LRU       OPT 
------------------------------------              -----------------------------------------------
1          60       60      50                    [r:10,f:3]       73.33     70.00     60.00 
------------------------------------              -----------------------------------------------
2          70       70      60                    [r:10,f:5]       70.00     73.33     70.00   
------------------------------------              -----------------------------------------------
3          90       80      70                    [r:10,f:7]       63.33     63.33     63.33   
------------------------------------              -----------------------------------------------
------------------------------------              [r:15,f:3]       73.33     77.78     60.00  
4          60       60      60                    -----------------------------------------------
------------------------------------              [r:15,f:5]       57.78     62.22     51.11  
5          70       80      70                    -----------------------------------------------
------------------------------------              [r:15,f:7]       55.56     55.56     55.56  
6          80       80      80                    -----------------------------------------------
------------------------------------              [r:20,f:3]       71.67     69.17     55.83 
------------------------------------              -----------------------------------------------
7          70       70      70                    [r:20,f:5]       56.67     60.00     46.67  
------------------------------------              -----------------------------------------------
8          50       50      50                    [r:20,f:7]       46.67     45.00     41.67  
------------------------------------              -----------------------------------------------
9          70       70      70      
------------------------------------
------------------------------------              Fault Rate Total Average Per Configuration:
10         67       73      60                    ---------------------------------
------------------------------------              Config Group      Average Rate 
11         80       87      67                    ---------------------------------
------------------------------------              [r:10,f:3]        67.78   
12         73       73      53                    ---------------------------------
------------------------------------              [r:10,f:5]        71.11  
------------------------------------              ---------------------------------
13         47       67      47                    [r:10,f:7]        63.33 
------------------------------------              ---------------------------------
14         67       60      53                    [r:15,f:3]        70.37   
------------------------------------              ---------------------------------
15         60       60      53                    [r:15,f:5]        57.04  
------------------------------------              ---------------------------------
------------------------------------              [r:15,f:7]        55.56    
16         53       53      53                    ---------------------------------
------------------------------------              [r:20,f:3]        65.56
17         60       60      60                    ---------------------------------
------------------------------------              [r:20,f:5]        54.44         
18         53       53      53                    ---------------------------------
------------------------------------              [r:20,f:7]        44.44 
------------------------------------              ---------------------------------
19         75       60      45      
------------------------------------
20         75       75      65         The Top 3 Configurations (for this run)  
------------------------------------   --------------------------------------------------------------------
21         80       80      65         1st Place: [r:20,f:7] - with a combined average fault rate of 44.44%
------------------------------------   --------------------------------------------------------------------
22         70       70      55         2nd Place: [r:20,f:5] - with a combined average fault rate of 54.44%
------------------------------------   --------------------------------------------------------------------
23         70       70      50         3rd Place: [r:15,f:7] - with a combined average fault rate of 55.56%
------------------------------------   --------------------------------------------------------------------
24         60       60      55      
------------------------------------
------------------------------------
25         70       65      55      
------------------------------------
26         60       70      45      
------------------------------------
27         40       45      40      
------------------------------------
------------------------------------
28         45       45      40      
------------------------------------
29         45       45      45      
------------------------------------
30         50       45      40      
------------------------------------
------------------------------------
</pre>
