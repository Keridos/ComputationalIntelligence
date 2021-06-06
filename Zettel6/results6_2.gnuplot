set xrange [0:500]
set xlabel "i"
set ylabel "x"
set title "Results 6.2"


plot "results-6_1.txt" title "X_0" with dots, \
     "results-6_2.txt" title "X" with dots,
