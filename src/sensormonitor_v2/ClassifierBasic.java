package sensormonitor_v2;

import android.Movements;

/**
 * Created by Michael Del Rosario on 31/03/2015.
 */
public class ClassifierBasic {
//    String TAG = "Classifier";
    public static final int STANDING  = Movements.STANDING;
    public static final int TRANSITION = Movements.TRANSITION;
    public static final int SEDENTARY   = Movements.SEDENTARY;
    public static final int WALKING    = Movements.WALKING;
    public static final int WALKUP     = Movements.WALKUP;
    public static final int WALKDN     = Movements.WALKDN;
    public static final int STATIONARY = Movements.STATIONARY;
    protected int state                = -1;

    /**
     * This is the decision tree algorithm obtained from WEKA
     * @param SumDifPre
     * @param SumSqBpfGyrXYZ
     * @param SumSqLpfDifAccXYZ
     * @return
     */
    public int classifyThreeFeaturesPMEAS(double SumDifPre, double SumSqBpfGyrXYZ, double SumSqLpfDifAccXYZ){
        if(SumSqBpfGyrXYZ <= 32.05795){
            if(SumSqLpfDifAccXYZ <= 1260.532842){
                if(SumSqBpfGyrXYZ <= 6.950407){
                    if(SumSqLpfDifAccXYZ <= 105.436218){
                        if(SumSqLpfDifAccXYZ <= 11.628291){
                            state=STATIONARY;
                        }
                        if(SumSqLpfDifAccXYZ > 11.628291){
                            if(SumSqBpfGyrXYZ <= 0.011064){
                                if(SumSqLpfDifAccXYZ <= 11.64133){
                                    state=TRANSITION;
                                }
                                if(SumSqLpfDifAccXYZ > 11.64133){
                                    if(SumSqLpfDifAccXYZ <= 22.584463){
                                        state=STATIONARY;
                                    }
                                    if(SumSqLpfDifAccXYZ > 22.584463){
                                        if(SumSqLpfDifAccXYZ <= 47.366436){
                                            if(SumSqLpfDifAccXYZ <= 42.708673){
                                                state=STATIONARY;
                                            }
                                            if(SumSqLpfDifAccXYZ > 42.708673){
                                                if(SumSqBpfGyrXYZ <= 0.008798){
                                                    state=TRANSITION;
                                                }
                                                if(SumSqBpfGyrXYZ > 0.008798){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                        if(SumSqLpfDifAccXYZ > 47.366436){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                            }
                            if(SumSqBpfGyrXYZ > 0.011064){
                                state=STATIONARY;
                            }
                        }
                    }
                    if(SumSqLpfDifAccXYZ > 105.436218){
                        if(SumSqLpfDifAccXYZ <= 327.438337){
                            state=STATIONARY;
                        }
                        if(SumSqLpfDifAccXYZ > 327.438337){
                            if(SumDifPre <= -7.828931){
                                if(SumSqBpfGyrXYZ <= 0.124582){
                                    state=TRANSITION;
                                }
                                if(SumSqBpfGyrXYZ > 0.124582){
                                    state=STATIONARY;
                                }
                            }
                            if(SumDifPre > -7.828931){
                                state=STATIONARY;
                            }
                        }
                    }
                }
                if(SumSqBpfGyrXYZ > 6.950407){
                    if(SumSqBpfGyrXYZ <= 21.063711){
                        state=STATIONARY;
                    }
                    if(SumSqBpfGyrXYZ > 21.063711){
                        if(SumDifPre <= -8.569499){
                            if(SumSqLpfDifAccXYZ <= 106.83529){
                                if(SumDifPre <= -12.424644){
                                    state=WALKING;
                                }
                                if(SumDifPre > -12.424644){
                                    if(SumSqBpfGyrXYZ <= 28.538246){
                                        state=STATIONARY;
                                    }
                                    if(SumSqBpfGyrXYZ > 28.538246){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumSqLpfDifAccXYZ > 106.83529){
                                state=STATIONARY;
                            }
                        }
                        if(SumDifPre > -8.569499){
                            state=STATIONARY;
                        }
                    }
                }
            }
            if(SumSqLpfDifAccXYZ > 1260.532842){
                if(SumSqLpfDifAccXYZ <= 3684.630639){
                    if(SumDifPre <= -14.339918){
                        if(SumSqBpfGyrXYZ <= 12.33917){
                            if(SumSqBpfGyrXYZ <= 1.585464){
                                if(SumSqLpfDifAccXYZ <= 1361.330739){
                                    state=TRANSITION;
                                }
                                if(SumSqLpfDifAccXYZ > 1361.330739){
                                    state=WALKING;
                                }
                            }
                            if(SumSqBpfGyrXYZ > 1.585464){
                                state=STATIONARY;
                            }
                        }
                        if(SumSqBpfGyrXYZ > 12.33917){
                            state=STATIONARY;
                        }
                    }
                    if(SumDifPre > -14.339918){
                        if(SumSqBpfGyrXYZ <= 18.244184){
                            state=STATIONARY;
                        }
                        if(SumSqBpfGyrXYZ > 18.244184){
                            if(SumSqLpfDifAccXYZ <= 2707.846348){
                                state=STATIONARY;
                            }
                            if(SumSqLpfDifAccXYZ > 2707.846348){
                                if(SumDifPre <= 6.698575){
                                    state=STATIONARY;
                                }
                                if(SumDifPre > 6.698575){
                                    if(SumSqBpfGyrXYZ <= 25.833128){
                                        if(SumSqBpfGyrXYZ <= 20.811235){
                                            state=TRANSITION;
                                        }
                                        if(SumSqBpfGyrXYZ > 20.811235){
                                            if(SumDifPre <= 18.854334){
                                                state=STATIONARY;
                                            }
                                            if(SumDifPre > 18.854334){
                                                state=WALKUP;
                                            }
                                        }
                                    }
                                    if(SumSqBpfGyrXYZ > 25.833128){
                                        state=WALKUP;
                                    }
                                }
                            }
                        }
                    }
                }
                if(SumSqLpfDifAccXYZ > 3684.630639){
                    if(SumDifPre <= 10.741055){
                        state=TRANSITION;
                    }
                    if(SumDifPre > 10.741055){
                        if(SumSqLpfDifAccXYZ <= 7495.523231){
                            if(SumSqBpfGyrXYZ <= 15.280895){
                                state=TRANSITION;
                            }
                            if(SumSqBpfGyrXYZ > 15.280895){
                                if(SumSqLpfDifAccXYZ <= 6315.158981){
                                    state=WALKUP;
                                }
                                if(SumSqLpfDifAccXYZ > 6315.158981){
                                    state=TRANSITION;
                                }
                            }
                        }
                        if(SumSqLpfDifAccXYZ > 7495.523231){
                            state=TRANSITION;
                        }
                    }
                }
            }
        }
        if(SumSqBpfGyrXYZ > 32.05795){
            if(SumSqLpfDifAccXYZ <= 149.856317){
                if(SumDifPre <= -19.137685){
                    if(SumDifPre <= -25.928234){
                        if(SumDifPre <= -56.97284){
                            state=STATIONARY;
                        }
                        if(SumDifPre > -56.97284){
                            if(SumSqLpfDifAccXYZ <= 11.396798){
                                state=WALKING;
                            }
                            if(SumSqLpfDifAccXYZ > 11.396798){
                                state=WALKDN;
                            }
                        }
                    }
                    if(SumDifPre > -25.928234){
                        state=WALKING;
                    }
                }
                if(SumDifPre > -19.137685){
                    if(SumDifPre <= 20.849264){
                        if(SumSqBpfGyrXYZ <= 60.798317){
                            state=WALKING;
                        }
                        if(SumSqBpfGyrXYZ > 60.798317){
                            if(SumDifPre <= -9.44214){
                                state=WALKING;
                            }
                            if(SumDifPre > -9.44214){
                                if(SumSqLpfDifAccXYZ <= 77.436825){
                                    state=WALKING;
                                }
                                if(SumSqLpfDifAccXYZ > 77.436825){
                                    if(SumDifPre <= 14.82775){
                                        state=WALKING;
                                    }
                                    if(SumDifPre > 14.82775){
                                        if(SumDifPre <= 17.561043){
                                            if(SumSqBpfGyrXYZ <= 124.462468){
                                                state=WALKING;
                                            }
                                            if(SumSqBpfGyrXYZ > 124.462468){
                                                if(SumSqLpfDifAccXYZ <= 113.094696){
                                                    if(SumSqLpfDifAccXYZ <= 86.641374){
                                                        state=WALKING;
                                                    }
                                                    if(SumSqLpfDifAccXYZ > 86.641374){
                                                        state=WALKUP;
                                                    }
                                                }
                                                if(SumSqLpfDifAccXYZ > 113.094696){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifPre > 17.561043){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(SumDifPre > 20.849264){
                        if(SumSqLpfDifAccXYZ <= 37.930578){
                            state=WALKING;
                        }
                        if(SumSqLpfDifAccXYZ > 37.930578){
                            if(SumDifPre <= 26.690649){
                                if(SumSqBpfGyrXYZ <= 74.3492){
                                    state=STATIONARY;
                                }
                                if(SumSqBpfGyrXYZ > 74.3492){
                                    if(SumSqLpfDifAccXYZ <= 59.958712){
                                        state=WALKING;
                                    }
                                    if(SumSqLpfDifAccXYZ > 59.958712){
                                        state=WALKUP;
                                    }
                                }
                            }
                            if(SumDifPre > 26.690649){
                                state=WALKUP;
                            }
                        }
                    }
                }
            }
            if(SumSqLpfDifAccXYZ > 149.856317){
                if(SumSqLpfDifAccXYZ <= 2344.958328){
                    if(SumDifPre <= 11.475189){
                        if(SumDifPre <= -11.394788){
                            if(SumDifPre <= -22.360314){
                                state=WALKDN;
                            }
                            if(SumDifPre > -22.360314){
                                if(SumSqBpfGyrXYZ <= 126.164455){
                                    if(SumDifPre <= -17.030032){
                                        if(SumSqLpfDifAccXYZ <= 1003.760152){
                                            state=WALKDN;
                                        }
                                        if(SumSqLpfDifAccXYZ > 1003.760152){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifPre > -17.030032){
                                        if(SumDifPre <= -13.467782){
                                            if(SumSqBpfGyrXYZ <= 112.767732){
                                                state=WALKING;
                                            }
                                            if(SumSqBpfGyrXYZ > 112.767732){
                                                if(SumSqBpfGyrXYZ <= 121.268267){
                                                    state=WALKDN;
                                                }
                                                if(SumSqBpfGyrXYZ > 121.268267){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifPre > -13.467782){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumSqBpfGyrXYZ > 126.164455){
                                    state=WALKING;
                                }
                            }
                        }
                        if(SumDifPre > -11.394788){
                            if(SumSqBpfGyrXYZ <= 71.215928){
                                if(SumSqLpfDifAccXYZ <= 958.543151){
                                    state=WALKING;
                                }
                                if(SumSqLpfDifAccXYZ > 958.543151){
                                    if(SumSqBpfGyrXYZ <= 53.866116){
                                        if(SumDifPre <= -6.702394){
                                            state=WALKING;
                                        }
                                        if(SumDifPre > -6.702394){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SumSqBpfGyrXYZ > 53.866116){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumSqBpfGyrXYZ > 71.215928){
                                if(SumSqBpfGyrXYZ <= 147.970147){
                                    if(SumSqLpfDifAccXYZ <= 1032.63193){
                                        state=WALKING;
                                    }
                                    if(SumSqLpfDifAccXYZ > 1032.63193){
                                        if(SumDifPre <= -6.679559){
                                            if(SumSqBpfGyrXYZ <= 129.998656){
                                                state=WALKING;
                                            }
                                            if(SumSqBpfGyrXYZ > 129.998656){
                                                state=TRANSITION;
                                            }
                                        }
                                        if(SumDifPre > -6.679559){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumSqBpfGyrXYZ > 147.970147){
                                    state=WALKING;
                                }
                            }
                        }
                    }
                    if(SumDifPre > 11.475189){
                        if(SumDifPre <= 16.669757){
                            state=WALKING;
                        }
                        if(SumDifPre > 16.669757){
                            if(SumSqBpfGyrXYZ <= 88.094128){
                                if(SumDifPre <= 47.022883){
                                    if(SumSqLpfDifAccXYZ <= 1176.189771){
                                        state=WALKING;
                                    }
                                    if(SumSqLpfDifAccXYZ > 1176.189771){
                                        state=WALKUP;
                                    }
                                }
                                if(SumDifPre > 47.022883){
                                    state=STATIONARY;
                                }
                            }
                            if(SumSqBpfGyrXYZ > 88.094128){
                                state=WALKUP;
                            }
                        }
                    }
                }
                if(SumSqLpfDifAccXYZ > 2344.958328){
                    if(SumDifPre <= 7.764658){
                        if(SumSqLpfDifAccXYZ <= 9100.784382){
                            if(SumDifPre <= -7.828931){
                                if(SumSqBpfGyrXYZ <= 108.139313){
                                    state=TRANSITION;
                                }
                                if(SumSqBpfGyrXYZ > 108.139313){
                                    if(SumSqBpfGyrXYZ <= 137.232379){
                                        if(SumDifPre <= -14.039658){
                                            state=WALKDN;
                                        }
                                        if(SumDifPre > -14.039658){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumSqBpfGyrXYZ > 137.232379){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumDifPre > -7.828931){
                                if(SumSqBpfGyrXYZ <= 59.87081){
                                    if(SumSqLpfDifAccXYZ <= 3174.645068){
                                        if(SumDifPre <= 1.849623){
                                            state=WALKING;
                                        }
                                        if(SumDifPre > 1.849623){
                                            state=TRANSITION;
                                        }
                                    }
                                    if(SumSqLpfDifAccXYZ > 3174.645068){
                                        state=TRANSITION;
                                    }
                                }
                                if(SumSqBpfGyrXYZ > 59.87081){
                                    if(SumSqLpfDifAccXYZ <= 4321.173188){
                                        if(SumSqBpfGyrXYZ <= 182.883853){
                                            if(SumDifPre <= 2.985146){
                                                if(SumSqLpfDifAccXYZ <= 3736.751181){
                                                    state=WALKING;
                                                }
                                                if(SumSqLpfDifAccXYZ > 3736.751181){
                                                    state=TRANSITION;
                                                }
                                            }
                                            if(SumDifPre > 2.985146){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumSqBpfGyrXYZ > 182.883853){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SumSqLpfDifAccXYZ > 4321.173188){
                                        if(SumSqBpfGyrXYZ <= 258.177081){
                                            state=TRANSITION;
                                        }
                                        if(SumSqBpfGyrXYZ > 258.177081){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                        }
                        if(SumSqLpfDifAccXYZ > 9100.784382){
                            state=TRANSITION;
                        }
                    }
                    if(SumDifPre > 7.764658){
                        if(SumSqLpfDifAccXYZ <= 7289.835981){
                            if(SumDifPre <= 22.055433){
                                if(SumSqBpfGyrXYZ <= 58.554248){
                                    if(SumSqBpfGyrXYZ <= 50.131767){
                                        if(SumDifPre <= 17.732224){
                                            if(SumSqBpfGyrXYZ <= 40.258292){
                                                if(SumSqBpfGyrXYZ <= 37.780547){
                                                    if(SumSqBpfGyrXYZ <= 33.041815){
                                                        state=WALKUP;
                                                    }
                                                    if(SumSqBpfGyrXYZ > 33.041815){
                                                        if(SumSqBpfGyrXYZ <= 35.833275){
                                                            if(SumSqLpfDifAccXYZ <= 3888.201646){
                                                                state=STATIONARY;
                                                            }
                                                            if(SumSqLpfDifAccXYZ > 3888.201646){
                                                                state=TRANSITION;
                                                            }
                                                        }
                                                        if(SumSqBpfGyrXYZ > 35.833275){
                                                            state=TRANSITION;
                                                        }
                                                    }
                                                }
                                                if(SumSqBpfGyrXYZ > 37.780547){
                                                    state=WALKUP;
                                                }
                                            }
                                            if(SumSqBpfGyrXYZ > 40.258292){
                                                if(SumSqLpfDifAccXYZ <= 4337.956717){
                                                    state=STATIONARY;
                                                }
                                                if(SumSqLpfDifAccXYZ > 4337.956717){
                                                    state=TRANSITION;
                                                }
                                            }
                                        }
                                        if(SumDifPre > 17.732224){
                                            state=WALKUP;
                                        }
                                    }
                                    if(SumSqBpfGyrXYZ > 50.131767){
                                        state=WALKUP;
                                    }
                                }
                                if(SumSqBpfGyrXYZ > 58.554248){
                                    state=WALKUP;
                                }
                            }
                            if(SumDifPre > 22.055433){
                                state=WALKUP;
                            }
                        }
                        if(SumSqLpfDifAccXYZ > 7289.835981){
                            state=TRANSITION;
                        }
                    }
                }
            }
        }
        return state;
    }
}
