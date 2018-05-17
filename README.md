# Human Activity Workbench

## 1 - Filter Coefficients

The sampling rates of the sensors which are processed with digital filters are listed below:

|Sensor| Sampling Rate | Filter Type | Pass Band | Filter Order | Filter Coefficients | 
|------|:-------------:|:-----------:|:---------:|:------------:|:-------------------:|
|      |               |             |           |              |                     |
|Accelerometer|<img src="https://latex.codecogs.com/svg.latex?\small&space;f_{acc}" title="f_{acc}" /> = 40 Hz | Low-pass Filter | <img src="https://latex.codecogs.com/svg.latex?\small&space;f_{c}" title="f_{c}" /> = 0.25 Hz            | N =  50  | <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpf,0.25}}" title="b_{\text{lpf,0.25}}" />                    |
|      |               |             |           |              |                    |
|Gyroscope|<img src="https://latex.codecogs.com/svg.latex?\small&space;f_{gyr}" title="f_{gyr}" /> = 40 Hz | Band-pass Filter| <img src="https://latex.codecogs.com/svg.latex?\small&space;f_{c}" title="f_{c}"/> = [1, 18] Hz           |  N =  99  | <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{bpf}}" title="b_{\text{bpf}}" />                   |
|      |               |             |           |              |                    |
|Barometer|<img src="https://latex.codecogs.com/svg.latex?\small&space;f_{bar}" title="f_{bar}" /> = 20 Hz | Low-pass Filter | <img src="https://latex.codecogs.com/svg.latex?\small&space;f_{c}" title="f_{c}" /> = 0.015 Hz            |  N =  80  |  <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpf,0.015}}" title="b_{\text{lpf,0.015}}" />                  |

### 1a - Discrete time convolution

The filter co-efficients blah and blah, described in the subsequent section are obtain by using the convolution operator to combine the filter co-efficients of blah and blah with a slope detection filter of order equal to the low pass filter.

## 2 - Pre-processing MEMS sensor data

The filter coefficients in section 1. were used to process the data from the tri-axial accelerometer, tri-axial gyroscope and barometric pressure sensor

The index k denotes the current time-step, N is the number of coefficients in the filter with coefficients <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.25}}" title="b_{\text{lpfdif,0.25}}" /> The accelerometer signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;a_{x}[k]" title="a_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N_{\text{lpfdif,0.25}}-1}{b_{\text{lpfdif,0.25}}[i]}{\cdotp}{a_{x}[k-i]}" title="\Large a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N_{\text{lpfdif,0.25}}-1}{b_{\text{lpfdif,0.25}}[i]}{\cdotp}{a_{x}[k-i]}" />

The index k denotes the current time-step, N is the number of coefficients in the band-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{bpf}}" title="b_{\text{bpf}}" />. The gyroscope signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;{\omega}_{x}[k]" title="{\omega}_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\omega_{\text{bpf},x}[k]=\sum_{i=0}^{N_{\text{bpf}}-1}{b_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" title="\Large \omega_{\text{bpf},x}[k]=\sum_{i=0}^{N_{\text{bpf}}-1}{b_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" />

The index k denotes the current time-step, N is the number of coefficients in the band-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;c_{\text{lpfdif}}" title="c_{\text{bpf}}" />. The barometer signal is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;p[k]" title="p[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]=\sum_{i=0}^{N_{\text{lpfdif,0.015}}-1}{b_{\text{lpfdif,0.015}}[i]}{\cdotp}{p[k-i]}" title="\Large {\partial}p[k]=\sum_{i=0}^{N_{\text{lpfdif,0.015}}-1}{b_{\text{lpfdif,0.015}}[i]}{\cdotp}{p[k-i]}" />

### 2a - Zero-order hold of the differential pressure signal 

Recall in Section 1 that the sampling rate of the barometer is less than the sampling rate of the accelerometer/gyroscope. Rather than up-sample the barometer measurements using the zero order hold. The pre-processed differential pressure signal <img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]" title="\Large {\partial}p[k]" /> is upsampled using the zero order hold

## 3 - Features summed/aggregated over the window
The signals processed in section 2. Processing MEMS sensor data

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" title="\Large \mathbf{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" title="\Large \mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\Delta}P[k]=\frac{1}{N}\sum_{i=0}^{N-1}{\partial}p[k-i]" title="\Large {\Delta}P[k]=\frac{1}{N}\sum_{i=0}^{N-1}{\partial}p[k-i]" />

  
