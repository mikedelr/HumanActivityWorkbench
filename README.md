# Human Activity Workbench

## Filter Coefficients

## Processing MEMS sensor data
<img src="https://latex.codecogs.com/svg.latex?\Large&space;a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N}{c_{\text{lpfdif}}[i]}{\cdotp}{x[k-i]}" title="\Large a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N}{c_{\text{lpfdif}}[i]}{\cdotp}{x[k-i]}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\omega_{\text{bpf},x}[k]=\sum_{i=0}^{N}{c_{\text{bpf}}[i]}{\cdotp}{\omega[k-i]}" title="\Large \omega_{\text{bpf},x}[k]=\sum_{i=0}^{N}{c_{\text{bpf}}[i]}{\cdotp}{x[k-i]}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]=\sum_{i=0}^{N}{c_{\text{lpfdif}}[i]}{\cdotp}{p[k-i]}" title="\Large {\partial}p[k]=\sum_{i=0}^{N}{c_{\text{lpfdif}}[i]}{\cdotp}{p[k-i]}" />

## Features summed/aggregated over the window

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\boldsymbol{\bar{\omega}}_{\text{bpf},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(\omega_{\text{bpf},x}^{2}+\omega_{\text{bpf},y}^{2}+\omega_{\text{bpf},z}^{2})_{j}" title="\Large \boldsymbol{\bar{\omega}}_{\text{bpf},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(\omega_{\text{bpf},x}^{2}+\omega_{\text{bpf},y}^{2}+\omega_{\text{bpf},z}^{2})_{j}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{a}}_{\text{lpfdif},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(a_{\text{lpfdif},x}^{2}+a_{\text{lpfdif},y}^{2}+a_{\text{lpfdif},z}^{2})_{j}" title="\Large \mathbf{\bar{a}}_{\text{lpfdif},k}^{2}=\frac{1}{N}\sum_{j=k-N+1}^{k}(a_{\text{lpfdif},x}^{2}+a_{\text{lpfdif},y}^{2}+a_{\text{lpfdif},z}^{2})_{j}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\Delta}P_{k}=\frac{1}{N}\sum_{j=k-N+1}^{k}{\partial}p_{k}" title="\Large {\Delta}P_{k}=\frac{1}{N}\sum_{j=k-N+1}^{k}{\partial}p_{k}" />

  
