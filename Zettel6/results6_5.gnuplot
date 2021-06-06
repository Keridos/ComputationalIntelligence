set xrange [0:2048]
set xlabel "i"
set ylabel "x"
set title "Results 6.5"


plot "results-6_5_x.txt" title "X_0" with dots, \
     "results-6_5_y.txt" title "Y_D5" with dots,