# Human Activity Workbench

## Filter Coefficients

## Processing MEMS sensor data

the index k denotes the current time-step, N is the number of coefficients in the filter with coefficients <img src="https://latex.codecogs.com/svg.latex?\small&space;c_{\text{lpfdif}}" title="c_{\text{lpfdif}}" /> The accelerometer signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;a_{x}[k]" title="a_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N-1}{c_{\text{lpfdif}}[i]}{\cdotp}{a_{x}[k-i]}" title="\Large a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N-1}{c_{\text{lpfdif}}[i]}{\cdotp}{a_{x}[k-i]}" />

the index k denotes the current time-step, N is the number of coefficients in the band-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;c_{\text{bpf}}" title="c_{\text{bpf}}" />. The gyroscope signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;{\omega}_{x}[k]" title="{\omega}_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\omega_{\text{bpf},x}[k]=\sum_{i=0}^{N-1}{c_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" title="\Large \omega_{\text{bpf},x}[k]=\sum_{i=0}^{N}{c_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" />

the index k denotes the current time-step, N is the number of coefficients in the band-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;c_{\text{lpfdif}}" title="c_{\text{bpf}}" />. The barometer signal is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;p[k]" title="p[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]=\sum_{i=0}^{N-1}{c_{\text{lpfdif}}[i]}{\cdotp}{p[k-i]}" title="\Large {\partial}p[k]=\sum_{i=0}^{N}{c_{\text{lpfdif}}[i]}{\cdotp}{p[k-i]}" />

## Features summed/aggregated over the window

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\boldsymbol{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" title="\Large \boldsymbol{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" title="\Large \mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\Delta}P[k]=\frac{1}{N}\sum_{i=0}^{N-1}{\partial}p[k-i]" title="\Large {\Delta}P[k]=\frac{1}{N}\sum_{i=0}^{N-1}{\partial}p[k-i]" />

  
