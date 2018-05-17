# Human Activity Workbench

## Filter Coefficients

## Processing MEMS sensor data

the index k denotes the current time-step, N is the number of coefficients in the filter with coefficients <img src="https://latex.codecogs.com/svg.latex?\small&space;c_{\text{lpfdif}}" title="c_{\text{lpfdif}}" /> The accelerometer signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;a_{x}" title="a_{x}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N-1}{c_{\text{lpfdif}}[i]}{\cdotp}{a_{x}[k-i]}" title="\Large a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N-1}{c_{\text{lpfdif}}[i]}{\cdotp}{a_{x}[k-i]}" />

the index k denotes the current time-step, N is the number of coefficients in the band-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;c_{\text{bpf}}" title="c_{\text{bpf}}" />. The gyroscope signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;{\omega}_{x}" title="{\omega}_{x}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\omega_{\text{bpf},x}[k]=\sum_{i=0}^{N-1}{c_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" title="\Large \omega_{\text{bpf},x}[k]=\sum_{i=0}^{N}{c_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]=\sum_{i=0}^{N-1}{c_{\text{lpfdif}}[i]}{\cdotp}{p[k-i]}" title="\Large {\partial}p[k]=\sum_{i=0}^{N}{c_{\text{lpfdif}}[i]}{\cdotp}{p[k-i]}" />

## Features summed/aggregated over the window

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\boldsymbol{\bar{\omega}}_{\text{bpf},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(\omega_{\text{bpf},x}^{2}+\omega_{\text{bpf},y}^{2}+\omega_{\text{bpf},z}^{2})_{j}" title="\Large \boldsymbol{\bar{\omega}}_{\text{bpf},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(\omega_{\text{bpf},x}^{2}+\omega_{\text{bpf},y}^{2}+\omega_{\text{bpf},z}^{2})_{j}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{a}}_{\text{lpfdif},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(a_{\text{lpfdif},x}^{2}+a_{\text{lpfdif},y}^{2}+a_{\text{lpfdif},z}^{2})_{j}" title="\Large \mathbf{\bar{a}}_{\text{lpfdif},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(a_{\text{lpfdif},x}^{2}+a_{\text{lpfdif},y}^{2}+a_{\text{lpfdif},z}^{2})_{j}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\Delta}P_{k}=\frac{1}{N}\sum_{j=k-N+1}^{k}{\partial}p_{k}" title="\Large {\Delta}P_{k}=\frac{1}{N}\sum_{j=k-N+1}^{k}{\partial}p_{k}" />

  
