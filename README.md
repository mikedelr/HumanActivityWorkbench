# Human Activity Workbench

This project processes the signals from a tri-axial accelerometer, tri-axial gyroscope and barometric pressure sensor to extract features which can be used by a machine learning algorithm to classify human activities

## 1 - Filter Design and Filter Coefficients

The sampling rates of the sensors which are processed with digital filters are listed below:

|Sensor| Sampling Rate | Filter Type | Pass Band | Filter Order | Filter Coefficients | 
|------|:-------------:|:-----------:|:---------:|:------------:|:-------------------:|
|      |               |             |           |              |                     |
|Accelerometer|<img src="https://latex.codecogs.com/svg.latex?\small&space;f_{acc}" title="f_{acc}" /> = 40 Hz | Low-pass Filter | <img src="https://latex.codecogs.com/svg.latex?\small&space;f_{c}" title="f_{c}" /> = 0.25 Hz            | N =  50  | <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpf,0.25}}" title="b_{\text{lpf,0.25}}" />                    |
|      |               |             |           |              |                    |
|Gyroscope|<img src="https://latex.codecogs.com/svg.latex?\small&space;f_{gyr}" title="f_{gyr}" /> = 40 Hz | Band-pass Filter| <img src="https://latex.codecogs.com/svg.latex?\small&space;f_{c}" title="f_{c}"/> = [1, 18] Hz           |  N =  99  | <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{bpf}}" title="b_{\text{bpf}}" />                   |
|      |               |             |           |              |                    |
|Barometer|<img src="https://latex.codecogs.com/svg.latex?\small&space;f_{bar}" title="f_{bar}" /> = 20 Hz | Low-pass Filter | <img src="https://latex.codecogs.com/svg.latex?\small&space;f_{c}" title="f_{c}" /> = 0.015 Hz            |  N =  80  |  <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpf,0.015}}" title="b_{\text{lpf,0.015}}" />                  |

### 1.1 - Discrete convolution

The filter co-efficients <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.25}}" title="b_{\text{lpfdif,0.25}}" /> and <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.015}}" title="b_{\text{lpfdif,0.015}}" />, described in the subsequent section are obtain by using convolution to combine the filter co-efficients of blah and blah (described in Section 1) with a slope detection filter of order equal to the low pass filter.

The coefficients for the sloping filter can be obtained from the following equation:

<img src="https://latex.codecogs.com/svg.latex?\small&space;{\beta}_{i}=\frac{12i-6(N-1)}{N(N^{2}-1)}" title="{\beta}_{i}=\frac{12i-6(N-1)}{N(N^{2}-1)}" /> 

See 'Slope Filtering: An FIR Approach to Linear Regression' section "REAL-TIME RATE OF CHANGE ESTIMATION", Eq. (8) [Available online: http://www.claysturner.com/dsp/fir_regression.pdf]

Finally these coefficients <img src="https://latex.codecogs.com/svg.latex?\small&space;{\beta}" title="{\beta}" /> are convolved with the coefficients for their respective low pass filter

<img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif}}[i]=\sum_{j=0}^{M-1}{\beta[j]}{b_{lpf}[i-j]}" title="b_{\text{lpfdif}}[i]=\sum_{j=0}^{M-1}{\beta[j]}{b_{lpf}[i-j]}" />


## 2 - Pre-processing MEMS sensor data

The filter coefficients in section 1. were used to process the data from the tri-axial accelerometer, tri-axial gyroscope and barometric pressure sensor

The index k denotes the current time-step, N is the number of coefficients in the filter with coefficients <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.25}}" title="b_{\text{lpfdif,0.25}}" /> The accelerometer signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;a_{x}[k]" title="a_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N_{\text{lpfdif,0.25}}-1}{b_{\text{lpfdif,0.25}}[i]}{\cdotp}{a_{x}[k-i]}" title="\Large a_{\text{lpfdif},x}[k]=\sum_{i=0}^{N_{\text{lpfdif,0.25}}-1}{b_{\text{lpfdif,0.25}}[i]}{\cdotp}{a_{x}[k-i]}" />

The index k denotes the current time-step, N is the number of coefficients in the band-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{bpf}}" title="b_{\text{bpf}}" />. The gyroscope signal along the x-axis is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;{\omega}_{x}[k]" title="{\omega}_{x}[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\omega_{\text{bpf},x}[k]=\sum_{i=0}^{N_{\text{bpf}}-1}{b_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" title="\Large \omega_{\text{bpf},x}[k]=\sum_{i=0}^{N_{\text{bpf}}-1}{b_{\text{bpf}}[i]}{\cdotp}{{\omega_{x}}[k-i]}" />

The index k denotes the current time-step, N is the number of coefficients in the low-pass filter whose coefficients are <img src="https://latex.codecogs.com/svg.latex?\small&space;b_{\text{lpfdif,0.015}}" title="b_{\text{lpfdif,0.015}}" />. The barometer signal is denoted by <img src="https://latex.codecogs.com/svg.latex?\small&space;p[k]" title="p[k]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]=\sum_{i=0}^{N_{\text{lpfdif,0.015}}-1}{b_{\text{lpfdif,0.015}}[i]}{\cdotp}{p[k-i]}" title="\Large {\partial}p[k]=\sum_{i=0}^{N_{\text{lpfdif,0.015}}-1}{b_{\text{lpfdif,0.015}}[i]}{\cdotp}{p[k-i]}" />

### 2.1 - Zero-order hold of the differential pressure signal 

Recall in Section 1 that the sampling rate of the barometer is less than the sampling rate of the accelerometer/gyroscope. Rather than up-sample the barometer measurements using the zero order hold. The pre-processed differential pressure signal <img src="https://latex.codecogs.com/svg.latex?\Large&space;{\partial}p[k]" title="\Large {\partial}p[k]" /> is upsampled using the zero order hold

Once the signals are pre-processed they are stored in a buffer whose size is at least equal to the length of the window over which the features are aggregated in Section 3 - "Features summed/aggregated over the window"

## 3 - Features summed/aggregated over the window
The signals processed in Section 2 - 'Pre-processing MEMS sensor data' are summed over a window of size <img src="https://latex.codecogs.com/svg.latex?\small&space;N_{\text{win}}" title="N_{\text{win}}" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N_{\text{win}}}\sum_{i=0}^{N_{\text{win}}-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" title="\Large \mathbf{\bar{\omega}}_{\text{bpf}}^{2}[k]=\frac{1}{N}\sum_{i=0}^{N_{\text{win}}-1}\omega_{\text{bpf},x}^{2}[k-i]+\omega_{\text{bpf},y}^{2}[k-i]+\omega_{\text{bpf},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N_{\text{win}}}\sum_{i=0}^{N_{\text{win}}-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" title="\Large \mathbf{\bar{a}}_{\text{lpfdif}}^{2}[k]=\frac{1}{N_{\text{win}}}\sum_{i=0}^{N_{\text{win}}-1}a_{\text{lpfdif},x}^{2}[k-i]+a_{\text{lpfdif},y}^{2}[k-i]+a_{\text{lpfdif},z}^{2}[k-i]" />

<img src="https://latex.codecogs.com/svg.latex?\Large&space;{\Delta}P[k]=\frac{1}{N_{\text{win}}}\sum_{i=0}^{N_{\text{win}}-1}{\partial}p[k-i]" title="\Large {\Delta}P[k]=\frac{1}{N_{\text{win}}}\sum_{i=0}^{N_{\text{win}}-1}{\partial}p[k-i]" />

Rather than sum all of the features in the buffer at each time-step, a running sum is maintainted and updated every time new sensor data is processed to reduce the amount of computations which need to be completed when features are extracted.

### 3.1 Maintaining a running sum
<img src="https://latex.codecogs.com/svg.latex?\Large&space;s[k]=\left[\sum_{i=0}^{N_{\text{win}}-1}x[k-i]\right]" title="\Large s[k]=\left[\sum_{i=0}^{N_{\text{win}}-1}x[k-i]\right]" />
or alternatively in terms of s[k-1]:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;s[k]=s[k-1]+x[k]-x[k-N_{\text{win}}]" title="\Large s[k]=s[k-1]+x[k]-x[k-N_{\text{win}}]" />

Note, x[k] is the sample to be added to the accumulated total, whilst x[k-N_{\text{win}}] is the sample to be removed from the accumulated total, thus the previous <img src="https://latex.codecogs.com/svg.latex?\Large&space;N_{\text{win}}" title="\Large N_{\text{win}}" /> samples need to be stored in a buffer
## 4 - Storing summed/aggregated features and window re-alignment to account for delay length
Before passing the features to a machine learning algorithm or a model previously trained with extracted features, the features need to be re-aligned in the time domain so that they are representative of the same point in time. Recall from Section 1 that FIR filters were chosen for their linear phase response (i.e., the filter delays all frequency components of the signal by the same amount, i.e., half the number of taps/filter coefficients). Consequently the delay of each pre-processed signal is:

| Filter Type | Number of Coefficients | Filter Coefficients | Delay |
|:-----------:|:------------:|:-------------------:|:-----:|
|             |        100    | <img src="https://latex.codecogs.com/svg.latex?\Large&space;b_{\text{bpf}}" title="\Large b_{\text{bpf}}" />                    | 50      |
|             |        100    | <img src="https://latex.codecogs.com/svg.latex?\Large&space;b_{\text{lpfdif,0.25}}" title="\Large b_{\text{lpfdif,0.25}}" />            | 50      |
|             |       160       |                     |   80    |

From this it is obvious that the processed accelerometer and gyroscope measurements need to be delayed so that the features extracted from them are representative of the same time point as the processed measurement from the barometer. 

The differential pressure requires at least 160 samples from the barometer before the processed signal can be generated. Once the signal is processed, it is representative of an event that occurred 80 samples previously. Assuming the sampling rates of the accelerometer, gyroscope, and barometer are constant, this corresponds to the 160 samples previously.

Since the accelerometer and gyroscope are 



In order to process the data as close to real-time as possible, we need to retrieve the filters that have a shorter delay length so that are
