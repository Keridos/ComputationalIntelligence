set xrange [0:2048]
set xlabel "i"
set ylabel "x"
set title "Results 6.3"


plot "results-6_3_x.txt" title "X" with dots, \
     "results-6_3_y.txt" title "Y" with dots,