set xrange [0:2000]
set xlabel "i"
set ylabel "x"
set title "Results 6.6"


plot "results-6_6_x.txt" title "X_s" with lines, \
     "results-6_6_y.txt" title "Y" with lines,