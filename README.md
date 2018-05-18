# Human Activity Workbench

This wiki will describe how the signals from a tri-axial accelerometer, tri-axial gyroscope and barometric pressure sensor can be processed/filtered for the purposes of building a machine learning algorithm which can be used to recognize human activities

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

### 1a - Discrete convolution

The filter co-efficients <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.25}}" title="b_{\text{lpfdif,0.25}}" /> and <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.015}}" title="b_{\text{lpfdif,0.015}}" />, described in the subsequent section are obtain by using convolution to combine the filter co-efficients of blah and blah (described in Section 1) with a slope detection filter of order equal to the low pass filter.

The coefficients for the sloping filter can be obtained from the following equation:

<img src="https://latex.codecogs.com/svg.latex?\small&space;{\beta}_{i}=\frac{12i-6(N-1)}{N(N^{2}-1)}" title="{\beta}_{i}=\frac{12i-6(N-1)}{N(N^{2}-1)}" /> 

See 'Slope Filtering: An FIR Approach to Linear Regression' section "REAL-TIME RATE OF CHANGE ESTIMATION", Eq. (8) [Available online: http://www.claysturner.com/dsp/fir_regression.pdf]

Finally these coefficients <img src="https://latex.codecogs.com/svg.latex?\small&space;{\beta}" title="{\beta}" /> are convolved with the coefficients for their respective low pass filter

<img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif}}[i]=\sum_{j}^{N}{\beta[j]}{b_{lpf}[i-j+1]}" title="b_{\text{lpfdif}}[i]=\sum_{j}^{N}{\beta[k]}{b_{lpf}[i-j+1]}" />


## 2 - Pre-processing MEMS sensor data

The filter coefficients in section 1. were used to process the data from the tri-axial accelerometer, tri-axial gyroscope and barometric pressure sensor

The index k denotes the current time-step, N is the number of coefficients in the filter with coefficients <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.25}}" title="b_{\text{lpfdif,0.25}}" /> The accelerometer signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;a_{x}[k]" title="a_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N_{\text{lpfdif,0.25}}-1}{b_{\text{lpfdif,0.25}}[i]}{\cdotp}{a_{x}[k-i]}" title="\Large a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N_{\text{lpfdif,0.25}}-1}{b_{\text{lpfdif,0.25}}[i]}{\cdotp}{a_{x}[k-i]}" />

The index k denotes the current time-step, N is the number of coefficients in the band-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{bpf}}" title="b_{\text{bpf}}" />. The gyroscope signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;{\omega}_{x}[k]" title="{\omega}_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\omega_{\text{bpf},x}[k]=\sum_{i=0}^{N_{\text{bpf}}-1}{b_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" title="\Large \omega_{\text{bpf},x}[k]=\sum_{i=0}^{N_{\text{bpf}}-1}{b_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" />

The index k denotes the current time-step, N is the number of coefficients in the low-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.015}}" title="b_{\text{lpfdif,0.015}}" />. The barometer signal is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;p[k]" title="p[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]=\sum_{i=0}^{N_{\text{lpfdif,0.015}}-1}{b_{\text{lpfdif,0.015}}[i]}{\cdotp}{p[k-i]}" title="\Large {\partial}p[k]=\sum_{i=0}^{N_{\text{lpfdif,0.015}}-1}{b_{\text{lpfdif,0.015}}[i]}{\cdotp}{p[k-i]}" />

### 2a - Zero-order hold of the differential pressure signal 

Recall in Section 1 that the sampling rate of the barometer is less than the sampling rate of the accelerometer/gyroscope. Rather than up-sample the barometer measurements using the zero order hold. The pre-processed differential pressure signal <img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]" title="\Large {\partial}p[k]" /> is upsampled using the zero order hold

## 3 - Features summed/aggregated over the window
The signals processed in section 2. Processing MEMS sensor data

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" title="\Large \mathbf{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" title="\Large \mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\Delta}P[k]=\frac{1}{N}\sum_{i=0}^{N-1}{\partial}p[k-i]" title="\Large {\Delta}P[k]=\frac{1}{N}\sum_{i=0}^{N-1}{\partial}p[k-i]" />

## 4 - Storing summed/aggregated features and window re-alignment to account for delay length
