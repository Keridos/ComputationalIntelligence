set xrange [0:2048]
set xlabel "i"
set ylabel "x"
set title "Results 6.7"


plot "results-6_7_x.txt" title "X_r" with lines, \
     "results-6_7_y.txt" title "X_r''" with lines,