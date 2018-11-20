#!/bin/bash
for ((i=1; i<=1000; i++))
    do curl "http://localhost:18181/helloWorld/simpleTextGreetings?name=heiko&gender=MALE"
done

# Test results (heap = 16 mb)
#real	0m15.057s
#user	0m3.896s
#sys	0m4.512s

# Test results (heap = no limit)
#real	0m15.826s
#user	0m4.059s
#sys	0m4.784s