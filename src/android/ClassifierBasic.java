package android;

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

    public int fiveFeatures(double SumDifPre,double SumGloAccXY, double SumGloGyrXY, double SumDifIncAng,double SqSumDifAccZ){
        state = -1;
        if(SumGloGyrXY <= 21.907331){
            if(SumGloGyrXY <= 3.3668){
                if(SumDifIncAng <= 98.786483){
                    if(SqSumDifAccZ <= 3.317883){
                        state=STATIONARY;
                    }
                    if(SqSumDifAccZ > 3.317883){
                        if(SumGloAccXY <= 36.700311){
                            state=STATIONARY;
                        }
                        if(SumGloAccXY > 36.700311){
                            if(SumGloAccXY <= 881.496801){
                                if(SqSumDifAccZ <= 393.937903){
                                    state=STATIONARY;
                                }
                                if(SqSumDifAccZ > 393.937903){
                                    state=WALKING;
                                }
                            }
                            if(SumGloAccXY > 881.496801){
                                state=STATIONARY;
                            }
                        }
                    }
                }
                if(SumDifIncAng > 98.786483){
                    state=STATIONARY;
                }
            }
            if(SumGloGyrXY > 3.3668){
                if(SumDifIncAng <= 95.644196){
                    if(SumGloAccXY <= 73.181336){
                        if(SumDifIncAng <= 85.77046){
                            if(SumDifIncAng <= 70.24224){
                                state=TRANSITION;
                            }
                            if(SumDifIncAng > 70.24224){
                                state=STATIONARY;
                            }
                        }
                        if(SumDifIncAng > 85.77046){
                            state=STATIONARY;
                        }
                    }
                    if(SumGloAccXY > 73.181336){
                        state=STATIONARY;
                    }
                }
                if(SumDifIncAng > 95.644196){
                    state=STATIONARY;
                }
            }
        }
        if(SumGloGyrXY > 21.907331){
            if(SumDifIncAng <= 91.481661){
                if(SumGloAccXY <= 313.985375){
                    if(SumDifPre <= 12.285172){
                        if(SumDifIncAng <= 54.679916){
                            state=TRANSITION;
                        }
                        if(SumDifIncAng > 54.679916){
                            if(SumGloAccXY <= 148.689441){
                                if(SumDifIncAng <= 86.335362){
                                    state=TRANSITION;
                                }
                                if(SumDifIncAng > 86.335362){
                                    state=STATIONARY;
                                }
                            }
                            if(SumGloAccXY > 148.689441){
                                if(SumDifPre <= 6.515675){
                                    if(SumDifIncAng <= 83.176386){
                                        if(SqSumDifAccZ <= 40.06742){
                                            state=TRANSITION;
                                        }
                                        if(SqSumDifAccZ > 40.06742){
                                            if(SumGloAccXY <= 177.437539){
                                                state=STATIONARY;
                                            }
                                            if(SumGloAccXY > 177.437539){
                                                if(SumDifIncAng <= 76.306275){
                                                    state=TRANSITION;
                                                }
                                                if(SumDifIncAng > 76.306275){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                    }
                                    if(SumDifIncAng > 83.176386){
                                        if(SumDifPre <= -7.071673){
                                            state=TRANSITION;
                                        }
                                        if(SumDifPre > -7.071673){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                                if(SumDifPre > 6.515675){
                                    if(SumGloGyrXY <= 78.961807){
                                        if(SumDifPre <= 8.774293){
                                            if(SumGloAccXY <= 273.847457){
                                                state=TRANSITION;
                                            }
                                            if(SumGloAccXY > 273.847457){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifPre > 8.774293){
                                            if(SumGloGyrXY <= 65.697865){
                                                if(SumGloGyrXY <= 53.290988){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloGyrXY > 53.290988){
                                                    state=TRANSITION;
                                                }
                                            }
                                            if(SumGloGyrXY > 65.697865){
                                                state=STATIONARY;
                                            }
                                        }
                                    }
                                    if(SumGloGyrXY > 78.961807){
                                        if(SqSumDifAccZ <= 58.715664){
                                            state=TRANSITION;
                                        }
                                        if(SqSumDifAccZ > 58.715664){
                                            state=WALKUP;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(SumDifPre > 12.285172){
                        if(SumDifIncAng <= 69.757482){
                            if(SumDifIncAng <= 58.824971){
                                state=TRANSITION;
                            }
                            if(SumDifIncAng > 58.824971){
                                if(SumGloGyrXY <= 94.125264){
                                    state=TRANSITION;
                                }
                                if(SumGloGyrXY > 94.125264){
                                    state=WALKUP;
                                }
                            }
                        }
                        if(SumDifIncAng > 69.757482){
                            if(SumGloGyrXY <= 49.31843){
                                if(SumGloAccXY <= 164.48548){
                                    state=TRANSITION;
                                }
                                if(SumGloAccXY > 164.48548){
                                    if(SumGloAccXY <= 222.505702){
                                        state=STATIONARY;
                                    }
                                    if(SumGloAccXY > 222.505702){
                                        if(SumGloAccXY <= 248.95613){
                                            state=WALKING;
                                        }
                                        if(SumGloAccXY > 248.95613){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 49.31843){
                                state=WALKUP;
                            }
                        }
                    }
                }
                if(SumGloAccXY > 313.985375){
                    if(SumDifPre <= 8.659076){
                        if(SumDifIncAng <= 62.711791){
                            if(SqSumDifAccZ <= 362.188001){
                                state=TRANSITION;
                            }
                            if(SqSumDifAccZ > 362.188001){
                                if(SumGloGyrXY <= 60.229193){
                                    state=STATIONARY;
                                }
                                if(SumGloGyrXY > 60.229193){
                                    if(SumDifIncAng <= -6.79968){
                                        if(SumDifIncAng <= -33.143841){
                                            if(SumDifPre <= -7.132462){
                                                state=TRANSITION;
                                            }
                                            if(SumDifPre > -7.132462){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SumDifIncAng > -33.143841){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifIncAng > -6.79968){
                                        if(SumDifPre <= -6.37892){
                                            if(SumDifIncAng <= 28.098945){
                                                state=TRANSITION;
                                            }
                                            if(SumDifIncAng > 28.098945){
                                                if(SumGloAccXY <= 3491.403145){
                                                    if(SumDifPre <= -10.615306){
                                                        if(SumGloAccXY <= 2472.390717){
                                                            state=TRANSITION;
                                                        }
                                                        if(SumGloAccXY > 2472.390717){
                                                            state=WALKING;
                                                        }
                                                    }
                                                    if(SumDifPre > -10.615306){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(SumGloAccXY > 3491.403145){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifPre > -6.37892){
                                            if(SqSumDifAccZ <= 2044.330921){
                                                if(SumDifIncAng <= 18.308456){
                                                    state=TRANSITION;
                                                }
                                                if(SumDifIncAng > 18.308456){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SqSumDifAccZ > 2044.330921){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(SumDifIncAng > 62.711791){
                            if(SumGloGyrXY <= 95.710416){
                                if(SqSumDifAccZ <= 50.573962){
                                    if(SumDifIncAng <= 87.093867){
                                        if(SumGloAccXY <= 1135.153478){
                                            if(SqSumDifAccZ <= 4.577599){
                                                state=TRANSITION;
                                            }
                                            if(SqSumDifAccZ > 4.577599){
                                                if(SqSumDifAccZ <= 7.615508){
                                                    state=TRANSITION;
                                                }
                                                if(SqSumDifAccZ > 7.615508){
                                                    if(SumDifIncAng <= 81.523359){
                                                        if(SumGloAccXY <= 668.056697){
                                                            state=TRANSITION;
                                                        }
                                                        if(SumGloAccXY > 668.056697){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(SumDifIncAng > 81.523359){
                                                        if(SumDifIncAng <= 81.822329){
                                                            state=STATIONARY;
                                                        }
                                                        if(SumDifIncAng > 81.822329){
                                                            if(SumGloGyrXY <= 84.585024){
                                                                state=STATIONARY;
                                                            }
                                                            if(SumGloGyrXY > 84.585024){
                                                                state=WALKING;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if(SumGloAccXY > 1135.153478){
                                            if(SumGloGyrXY <= 37.541563){
                                                state=STATIONARY;
                                            }
                                            if(SumGloGyrXY > 37.541563){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                    if(SumDifIncAng > 87.093867){
                                        if(SumDifPre <= -7.858796){
                                            if(SqSumDifAccZ <= 31.582086){
                                                state=WALKING;
                                            }
                                            if(SqSumDifAccZ > 31.582086){
                                                if(SumGloAccXY <= 783.575181){
                                                    state=WALKDN;
                                                }
                                                if(SumGloAccXY > 783.575181){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifPre > -7.858796){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SqSumDifAccZ > 50.573962){
                                    if(SumGloGyrXY <= 63.745037){
                                        state=STATIONARY;
                                    }
                                    if(SumGloGyrXY > 63.745037){
                                        if(SumGloAccXY <= 444.854816){
                                            state=TRANSITION;
                                        }
                                        if(SumGloAccXY > 444.854816){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 95.710416){
                                if(SumDifPre <= -14.979565){
                                    state=WALKING;
                                }
                                if(SumDifPre > -14.979565){
                                    if(SumGloAccXY <= 1244.48431){
                                        if(SumDifIncAng <= 80.275282){
                                            if(SumDifPre <= 6.60055){
                                                if(SqSumDifAccZ <= 25.070477){
                                                    state=TRANSITION;
                                                }
                                                if(SqSumDifAccZ > 25.070477){
                                                    if(SumGloAccXY <= 393.298887){
                                                        state=TRANSITION;
                                                    }
                                                    if(SumGloAccXY > 393.298887){
                                                        state=WALKING;
                                                    }
                                                }
                                            }
                                            if(SumDifPre > 6.60055){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifIncAng > 80.275282){
                                            if(SumDifPre <= 3.720591){
                                                if(SumGloAccXY <= 379.393738){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloAccXY > 379.393738){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumDifPre > 3.720591){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                    if(SumGloAccXY > 1244.48431){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                    if(SumDifPre > 8.659076){
                        if(SumDifIncAng <= 62.346783){
                            if(SumDifPre <= 21.427167){
                                if(SqSumDifAccZ <= 482.99019){
                                    if(SumDifIncAng <= 37.590374){
                                        state=TRANSITION;
                                    }
                                    if(SumDifIncAng > 37.590374){
                                        if(SumGloGyrXY <= 120.998418){
                                            if(SumGloGyrXY <= 111.812112){
                                                if(SqSumDifAccZ <= 26.538729){
                                                    state=TRANSITION;
                                                }
                                                if(SqSumDifAccZ > 26.538729){
                                                    if(SumDifPre <= 11.75511){
                                                        state=TRANSITION;
                                                    }
                                                    if(SumDifPre > 11.75511){
                                                        if(SumDifPre <= 14.262302){
                                                            state=WALKING;
                                                        }
                                                        if(SumDifPre > 14.262302){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                }
                                            }
                                            if(SumGloGyrXY > 111.812112){
                                                state=WALKUP;
                                            }
                                        }
                                        if(SumGloGyrXY > 120.998418){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SqSumDifAccZ > 482.99019){
                                    state=WALKING;
                                }
                            }
                            if(SumDifPre > 21.427167){
                                if(SumGloGyrXY <= 243.119186){
                                    state=TRANSITION;
                                }
                                if(SumGloGyrXY > 243.119186){
                                    if(SumDifPre <= 32.434284){
                                        state=WALKING;
                                    }
                                    if(SumDifPre > 32.434284){
                                        state=WALKUP;
                                    }
                                }
                            }
                        }
                        if(SumDifIncAng > 62.346783){
                            if(SumGloGyrXY <= 93.435131){
                                if(SumGloAccXY <= 487.494301){
                                    if(SumDifIncAng <= 77.232614){
                                        state=TRANSITION;
                                    }
                                    if(SumDifIncAng > 77.232614){
                                        state=WALKING;
                                    }
                                }
                                if(SumGloAccXY > 487.494301){
                                    state=WALKING;
                                }
                            }
                            if(SumGloGyrXY > 93.435131){
                                if(SumGloGyrXY <= 260.170277){
                                    if(SqSumDifAccZ <= 40.565945){
                                        state=WALKING;
                                    }
                                    if(SqSumDifAccZ > 40.565945){
                                        if(SumGloAccXY <= 505.335829){
                                            if(SqSumDifAccZ <= 55.377072){
                                                if(SumDifPre <= 23.132893){
                                                    state=WALKING;
                                                }
                                                if(SumDifPre > 23.132893){
                                                    state=WALKUP;
                                                }
                                            }
                                            if(SqSumDifAccZ > 55.377072){
                                                state=WALKUP;
                                            }
                                        }
                                        if(SumGloAccXY > 505.335829){
                                            if(SumGloAccXY <= 1368.066249){
                                                state=WALKUP;
                                            }
                                            if(SumGloAccXY > 1368.066249){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                                if(SumGloGyrXY > 260.170277){
                                    state=WALKUP;
                                }
                            }
                        }
                    }
                }
            }
            if(SumDifIncAng > 91.481661){
                if(SumDifPre <= -13.030464){
                    if(SqSumDifAccZ <= 4.442205){
                        if(SumDifPre <= -27.830673){
                            if(SumGloAccXY <= 968.95099){
                                state=WALKDN;
                            }
                            if(SumGloAccXY > 968.95099){
                                if(SumGloGyrXY <= 85.875756){
                                    state=WALKING;
                                }
                                if(SumGloGyrXY > 85.875756){
                                    state=WALKDN;
                                }
                            }
                        }
                        if(SumDifPre > -27.830673){
                            state=WALKING;
                        }
                    }
                    if(SqSumDifAccZ > 4.442205){
                        if(SumDifPre <= -22.360314){
                            if(SumDifPre <= -43.520168){
                                if(SumGloGyrXY <= 78.675943){
                                    state=STATIONARY;
                                }
                                if(SumGloGyrXY > 78.675943){
                                    state=WALKDN;
                                }
                            }
                            if(SumDifPre > -43.520168){
                                state=WALKDN;
                            }
                        }
                        if(SumDifPre > -22.360314){
                            if(SumGloGyrXY <= 51.988347){
                                if(SumGloAccXY <= 131.722884){
                                    state=STATIONARY;
                                }
                                if(SumGloAccXY > 131.722884){
                                    if(SumDifIncAng <= 95.075174){
                                        state=STATIONARY;
                                    }
                                    if(SumDifIncAng > 95.075174){
                                        if(SqSumDifAccZ <= 9.294636){
                                            if(SumDifPre <= -17.129924){
                                                if(SumGloGyrXY <= 37.055789){
                                                    state=WALKDN;
                                                }
                                                if(SumGloGyrXY > 37.055789){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumDifPre > -17.129924){
                                                if(SumGloAccXY <= 311.883461){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloAccXY > 311.883461){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SqSumDifAccZ > 9.294636){
                                            if(SumDifIncAng <= 98.588566){
                                                if(SumDifPre <= -17.816438){
                                                    state=WALKDN;
                                                }
                                                if(SumDifPre > -17.816438){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumDifIncAng > 98.588566){
                                                state=WALKDN;
                                            }
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 51.988347){
                                if(SumGloAccXY <= 993.99159){
                                    if(SumDifIncAng <= 95.499941){
                                        if(SqSumDifAccZ <= 20.838122){
                                            state=WALKING;
                                        }
                                        if(SqSumDifAccZ > 20.838122){
                                            state=WALKDN;
                                        }
                                    }
                                    if(SumDifIncAng > 95.499941){
                                        state=WALKDN;
                                    }
                                }
                                if(SumGloAccXY > 993.99159){
                                    state=WALKING;
                                }
                            }
                        }
                    }
                }
                if(SumDifPre > -13.030464){
                    if(SumDifPre <= 14.127219){
                        if(SumGloAccXY <= 379.662196){
                            if(SumGloAccXY <= 203.330897){
                                if(SumGloAccXY <= 109.195677){
                                    state=STATIONARY;
                                }
                                if(SumGloAccXY > 109.195677){
                                    if(SqSumDifAccZ <= 4.341011){
                                        if(SumDifIncAng <= 97.965362){
                                            state=STATIONARY;
                                        }
                                        if(SumDifIncAng > 97.965362){
                                            state=WALKING;
                                        }
                                    }
                                    if(SqSumDifAccZ > 4.341011){
                                        state=STATIONARY;
                                    }
                                }
                            }
                            if(SumGloAccXY > 203.330897){
                                state=WALKING;
                            }
                        }
                        if(SumGloAccXY > 379.662196){
                            if(SumGloGyrXY <= 83.15176){
                                if(SumDifIncAng <= 98.518474){
                                    if(SumGloGyrXY <= 42.501639){
                                        state=WALKING;
                                    }
                                    if(SumGloGyrXY > 42.501639){
                                        if(SumDifPre <= -6.951298){
                                            if(SqSumDifAccZ <= 8.436221){
                                                state=WALKING;
                                            }
                                            if(SqSumDifAccZ > 8.436221){
                                                if(SumDifIncAng <= 92.994888){
                                                    if(SumDifPre <= -8.655473){
                                                        state=WALKDN;
                                                    }
                                                    if(SumDifPre > -8.655473){
                                                        state=TRANSITION;
                                                    }
                                                }
                                                if(SumDifIncAng > 92.994888){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifPre > -6.951298){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifIncAng > 98.518474){
                                    if(SqSumDifAccZ <= 13.520501){
                                        state=WALKING;
                                    }
                                    if(SqSumDifAccZ > 13.520501){
                                        if(SumDifPre <= -6.931267){
                                            state=WALKING;
                                        }
                                        if(SumDifPre > -6.931267){
                                            if(SumGloGyrXY <= 38.466777){
                                                if(SumGloAccXY <= 898.80978){
                                                    state=WALKING;
                                                }
                                                if(SumGloAccXY > 898.80978){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(SumGloGyrXY > 38.466777){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 83.15176){
                                state=WALKING;
                            }
                        }
                    }
                    if(SumDifPre > 14.127219){
                        if(SqSumDifAccZ <= 8.78311){
                            if(SumDifPre <= 25.695551){
                                if(SumGloAccXY <= 208.27371){
                                    if(SumGloAccXY <= 188.84551){
                                        state=STATIONARY;
                                    }
                                    if(SumGloAccXY > 188.84551){
                                        state=WALKING;
                                    }
                                }
                                if(SumGloAccXY > 208.27371){
                                    state=WALKING;
                                }
                            }
                            if(SumDifPre > 25.695551){
                                if(SqSumDifAccZ <= 2.313569){
                                    state=WALKING;
                                }
                                if(SqSumDifAccZ > 2.313569){
                                    if(SumGloAccXY <= 1896.711304){
                                        state=WALKUP;
                                    }
                                    if(SumGloAccXY > 1896.711304){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                        if(SqSumDifAccZ > 8.78311){
                            if(SumGloGyrXY <= 94.74296){
                                if(SumGloGyrXY <= 61.795579){
                                    state=WALKING;
                                }
                                if(SumGloGyrXY > 61.795579){
                                    if(SumGloAccXY <= 622.326279){
                                        state=WALKUP;
                                    }
                                    if(SumGloAccXY > 622.326279){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumGloGyrXY > 94.74296){
                                if(SumGloAccXY <= 1707.065524){
                                    state=WALKUP;
                                }
                                if(SumGloAccXY > 1707.065524){
                                    if(SumGloGyrXY <= 262.85207){
                                        state=WALKING;
                                    }
                                    if(SumGloGyrXY > 262.85207){
                                        if(SumGloAccXY <= 2174.358654){
                                            state=WALKUP;
                                        }
                                        if(SumGloAccXY > 2174.358654){
                                            if(SumGloGyrXY <= 350.166094){
                                                state=WALKING;
                                            }
                                            if(SumGloGyrXY > 350.166094){
                                                state=WALKUP;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return state;
    }


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

    public int classifyFiveFeatures(double SumGloAccXY, double SumGloGyrXY, double SumDifPre, double SumDifIncAng, double SumDifAccZ){
        state = -1;
        if(SumGloGyrXY <= 23.966792){
            if(SumGloGyrXY <= 3.371761){
                state=STATIONARY;
            }
            if(SumGloGyrXY > 3.371761){
                if(SumDifIncAng <= 93.433831){
                    if(SumGloAccXY <= 57.984053){
                        if(SumDifIncAng <= 80.155056){
                            state=TRANSITION;
                        }
                        if(SumDifIncAng > 80.155056){
                            state=STATIONARY;
                        }
                    }
                    if(SumGloAccXY > 57.984053){
                        if(SumDifAccZ <= 125.150662){
                            if(SumGloGyrXY <= 20.538278){
                                if(SumDifPre <= -10.15634){
                                    state=STATIONARY;
                                }
                                if(SumDifPre > -10.15634){
                                    if(SumDifAccZ <= 18.044813){
                                        if(SumDifIncAng <= 69.646994){
                                            if(SumGloAccXY <= 7149.723986){
                                                if(SumGloGyrXY <= 17.306843){
                                                    state=WALKING;
                                                }
                                                if(SumGloGyrXY > 17.306843){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(SumGloAccXY > 7149.723986){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SumDifIncAng > 69.646994){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SumDifAccZ > 18.044813){
                                        state=STATIONARY;
                                    }
                                }
                            }
                            if(SumGloGyrXY > 20.538278){
                                state=STATIONARY;
                            }
                        }
                        if(SumDifAccZ > 125.150662){
                            if(SumDifAccZ <= 504.338588){
                                if(SumGloAccXY <= 431.46292){
                                    state=WALKING;
                                }
                                if(SumGloAccXY > 431.46292){
                                    if(SumDifPre <= -14.301981){
                                        state=TRANSITION;
                                    }
                                    if(SumDifPre > -14.301981){
                                        if(SumGloGyrXY <= 13.53773){
                                            state=STATIONARY;
                                        }
                                        if(SumGloGyrXY > 13.53773){
                                            if(SumDifIncAng <= 49.454685){
                                                state=WALKING;
                                            }
                                            if(SumDifIncAng > 49.454685){
                                                if(SumGloAccXY <= 4105.839533){
                                                    if(SumDifAccZ <= 240.894499){
                                                        state=STATIONARY;
                                                    }
                                                    if(SumDifAccZ > 240.894499){
                                                        state=WALKING;
                                                    }
                                                }
                                                if(SumGloAccXY > 4105.839533){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(SumDifAccZ > 504.338588){
                                state=WALKUP;
                            }
                        }
                    }
                }
                if(SumDifIncAng > 93.433831){
                    if(SumGloGyrXY <= 11.278178){
                        state=STATIONARY;
                    }
                    if(SumGloGyrXY > 11.278178){
                        if(SumGloAccXY <= 70.477175){
                            state=STATIONARY;
                        }
                        if(SumGloAccXY > 70.477175){
                            if(SumDifPre <= -8.847475){
                                state=STATIONARY;
                            }
                            if(SumDifPre > -8.847475){
                                if(SumGloGyrXY <= 14.863534){
                                    state=STATIONARY;
                                }
                                if(SumGloGyrXY > 14.863534){
                                    if(SumGloAccXY <= 160.009396){
                                        if(SumDifPre <= -0.499653){
                                            if(SumDifAccZ <= 12.092346){
                                                state=STATIONARY;
                                            }
                                            if(SumDifAccZ > 12.092346){
                                                state=TRANSITION;
                                            }
                                        }
                                        if(SumDifPre > -0.499653){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SumGloAccXY > 160.009396){
                                        if(SumDifIncAng <= 99.301874){
                                            state=STATIONARY;
                                        }
                                        if(SumDifIncAng > 99.301874){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(SumGloGyrXY > 23.966792){
            if(SumDifIncAng <= 89.086535){
                if(SumGloAccXY <= 438.636363){
                    if(SumDifIncAng <= 73.880665){
                        if(SumDifIncAng <= 46.984921){
                            state=TRANSITION;
                        }
                        if(SumDifIncAng > 46.984921){
                            if(SumDifPre <= 12.543664){
                                if(SumGloAccXY <= 160.22755){
                                    if(SumGloGyrXY <= 65.888515){
                                        state=TRANSITION;
                                    }
                                    if(SumGloGyrXY > 65.888515){
                                        if(SumDifPre <= 10.714679){
                                            state=TRANSITION;
                                        }
                                        if(SumDifPre > 10.714679){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                                if(SumGloAccXY > 160.22755){
                                    if(SumDifAccZ <= 77.694241){
                                        if(SumDifPre <= 6.916411){
                                            if(SumDifAccZ <= 16.33646){
                                                state=TRANSITION;
                                            }
                                            if(SumDifAccZ > 16.33646){
                                                if(SumDifIncAng <= 68.998908){
                                                    state=TRANSITION;
                                                }
                                                if(SumDifIncAng > 68.998908){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                        if(SumDifPre > 6.916411){
                                            state=TRANSITION;
                                        }
                                    }
                                    if(SumDifAccZ > 77.694241){
                                        if(SumDifPre <= 5.390014){
                                            state=WALKING;
                                        }
                                        if(SumDifPre > 5.390014){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                            }
                            if(SumDifPre > 12.543664){
                                if(SumGloGyrXY <= 96.318717){
                                    state=TRANSITION;
                                }
                                if(SumGloGyrXY > 96.318717){
                                    state=WALKUP;
                                }
                            }
                        }
                    }
                    if(SumDifIncAng > 73.880665){
                        if(SumDifPre <= 10.91449){
                            if(SumGloAccXY <= 229.099618){
                                if(SumDifPre <= 4.94065){
                                    state=STATIONARY;
                                }
                                if(SumDifPre > 4.94065){
                                    if(SumGloGyrXY <= 44.500998){
                                        if(SumDifIncAng <= 83.615981){
                                            state=TRANSITION;
                                        }
                                        if(SumDifIncAng > 83.615981){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SumGloGyrXY > 44.500998){
                                        state=TRANSITION;
                                    }
                                }
                            }
                            if(SumGloAccXY > 229.099618){
                                state=WALKING;
                            }
                        }
                        if(SumDifPre > 10.91449){
                            if(SumGloGyrXY <= 66.355329){
                                if(SumGloAccXY <= 167.225877){
                                    if(SumGloGyrXY <= 38.330433){
                                        state=TRANSITION;
                                    }
                                    if(SumGloGyrXY > 38.330433){
                                        if(SumDifAccZ <= -10.425949){
                                            state=STATIONARY;
                                        }
                                        if(SumDifAccZ > -10.425949){
                                            state=WALKUP;
                                        }
                                    }
                                }
                                if(SumGloAccXY > 167.225877){
                                    if(SumDifPre <= 22.696635){
                                        if(SumGloGyrXY <= 37.758579){
                                            state=STATIONARY;
                                        }
                                        if(SumGloGyrXY > 37.758579){
                                            state=TRANSITION;
                                        }
                                    }
                                    if(SumDifPre > 22.696635){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumGloGyrXY > 66.355329){
                                state=WALKUP;
                            }
                        }
                    }
                }
                if(SumGloAccXY > 438.636363){
                    if(SumDifPre <= 13.477925){
                        if(SumDifIncAng <= 69.124787){
                            if(SumDifAccZ <= 57.359794){
                                if(SumDifIncAng <= 59.419913){
                                    if(SumGloAccXY <= 5295.884019){
                                        if(SumDifPre <= -0.7629){
                                            if(SumDifPre <= -14.951247){
                                                state=TRANSITION;
                                            }
                                            if(SumDifPre > -14.951247){
                                                if(SumDifAccZ <= 20.325077){
                                                    if(SumDifIncAng <= 33.809677){
                                                        state=TRANSITION;
                                                    }
                                                    if(SumDifIncAng > 33.809677){
                                                        if(SumDifAccZ <= -263.091161){
                                                            state=STATIONARY;
                                                        }
                                                        if(SumDifAccZ > -263.091161){
                                                            state=TRANSITION;
                                                        }
                                                    }
                                                }
                                                if(SumDifAccZ > 20.325077){
                                                    state=TRANSITION;
                                                }
                                            }
                                        }
                                        if(SumDifPre > -0.7629){
                                            state=TRANSITION;
                                        }
                                    }
                                    if(SumGloAccXY > 5295.884019){
                                        if(SumGloGyrXY <= 65.008558){
                                            state=STATIONARY;
                                        }
                                        if(SumGloGyrXY > 65.008558){
                                            if(SumDifIncAng <= 32.086114){
                                                if(SumDifIncAng <= -3.563058){
                                                    state=TRANSITION;
                                                }
                                                if(SumDifIncAng > -3.563058){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumDifIncAng > 32.086114){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                                if(SumDifIncAng > 59.419913){
                                    if(SumGloGyrXY <= 36.982992){
                                        state=STATIONARY;
                                    }
                                    if(SumGloGyrXY > 36.982992){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumDifAccZ > 57.359794){
                                if(SumDifPre <= -9.105467){
                                    state=TRANSITION;
                                }
                                if(SumDifPre > -9.105467){
                                    if(SumGloGyrXY <= 63.93266){
                                        if(SumDifPre <= -0.85569){
                                            state=STATIONARY;
                                        }
                                        if(SumDifPre > -0.85569){
                                            if(SumGloAccXY <= 6151.62781){
                                                if(SumDifIncAng <= 36.244112){
                                                    state=WALKING;
                                                }
                                                if(SumDifIncAng > 36.244112){
                                                    if(SumGloAccXY <= 1350.351738){
                                                        if(SumGloGyrXY <= 56.750444){
                                                            if(SumGloAccXY <= 757.160664){
                                                                if(SumGloGyrXY <= 34.874671){
                                                                    state=WALKING;
                                                                }
                                                                if(SumGloGyrXY > 34.874671){
                                                                    if(SumDifPre <= 3.385813){
                                                                        state=STATIONARY;
                                                                    }
                                                                    if(SumDifPre > 3.385813){
                                                                        state=WALKING;
                                                                    }
                                                                }
                                                            }
                                                            if(SumGloAccXY > 757.160664){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(SumGloGyrXY > 56.750444){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(SumGloAccXY > 1350.351738){
                                                        if(SumDifPre <= 6.571181){
                                                            if(SumGloGyrXY <= 42.228092){
                                                                state=STATIONARY;
                                                            }
                                                            if(SumGloGyrXY > 42.228092){
                                                                if(SumDifPre <= -0.395917){
                                                                    state=WALKING;
                                                                }
                                                                if(SumDifPre > -0.395917){
                                                                    if(SumGloGyrXY <= 61.460492){
                                                                        state=STATIONARY;
                                                                    }
                                                                    if(SumGloGyrXY > 61.460492){
                                                                        state=WALKING;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if(SumDifPre > 6.571181){
                                                            state=WALKING;
                                                        }
                                                    }
                                                }
                                            }
                                            if(SumGloAccXY > 6151.62781){
                                                state=STATIONARY;
                                            }
                                        }
                                    }
                                    if(SumGloGyrXY > 63.93266){
                                        if(SumDifIncAng <= -7.312899){
                                            if(SumDifIncAng <= -33.143841){
                                                state=STATIONARY;
                                            }
                                            if(SumDifIncAng > -33.143841){
                                                if(SumDifPre <= 6.212969){
                                                    if(SumDifIncAng <= -11.41152){
                                                        state=WALKING;
                                                    }
                                                    if(SumDifIncAng > -11.41152){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(SumDifPre > 6.212969){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                        if(SumDifIncAng > -7.312899){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                        }
                        if(SumDifIncAng > 69.124787){
                            if(SumGloGyrXY <= 51.632201){
                                state=STATIONARY;
                            }
                            if(SumGloGyrXY > 51.632201){
                                if(SumDifPre <= -14.834106){
                                    if(SumGloAccXY <= 1038.768481){
                                        state=TRANSITION;
                                    }
                                    if(SumGloAccXY > 1038.768481){
                                        if(SumGloGyrXY <= 104.379905){
                                            if(SumGloGyrXY <= 82.546303){
                                                state=WALKING;
                                            }
                                            if(SumGloGyrXY > 82.546303){
                                                if(SumGloGyrXY <= 97.331933){
                                                    state=TRANSITION;
                                                }
                                                if(SumGloGyrXY > 97.331933){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumGloGyrXY > 104.379905){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifPre > -14.834106){
                                    state=WALKING;
                                }
                            }
                        }
                    }
                    if(SumDifPre > 13.477925){
                        if(SumDifIncAng <= 58.131045){
                            if(SumDifPre <= 36.13338){
                                if(SumGloAccXY <= 634.985068){
                                    if(SumDifAccZ <= 40.477718){
                                        state=TRANSITION;
                                    }
                                    if(SumDifAccZ > 40.477718){
                                        state=WALKING;
                                    }
                                }
                                if(SumGloAccXY > 634.985068){
                                    if(SumGloGyrXY <= 135.202215){
                                        if(SumDifAccZ <= 15.909922){
                                            state=TRANSITION;
                                        }
                                        if(SumDifAccZ > 15.909922){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumGloGyrXY > 135.202215){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumDifPre > 36.13338){
                                state=WALKUP;
                            }
                        }
                        if(SumDifIncAng > 58.131045){
                            if(SumGloGyrXY <= 125.331986){
                                if(SumGloGyrXY <= 55.31039){
                                    if(SumDifIncAng <= 81.229642){
                                        state=STATIONARY;
                                    }
                                    if(SumDifIncAng > 81.229642){
                                        state=WALKING;
                                    }
                                }
                                if(SumGloGyrXY > 55.31039){
                                    state=WALKING;
                                }
                            }
                            if(SumGloGyrXY > 125.331986){
                                state=WALKUP;
                            }
                        }
                    }
                }
            }
            if(SumDifIncAng > 89.086535){
                if(SumDifPre <= -15.135134){
                    if(SumDifPre <= -23.855606){
                        if(SumDifPre <= -60.788336){
                            state=STATIONARY;
                        }
                        if(SumDifPre > -60.788336){
                            state=WALKDN;
                        }
                    }
                    if(SumDifPre > -23.855606){
                        if(SumDifAccZ <= -4.64123){
                            if(SumDifIncAng <= 99.618175){
                                if(SumDifIncAng <= 94.999294){
                                    if(SumGloGyrXY <= 115.911466){
                                        state=WALKING;
                                    }
                                    if(SumGloGyrXY > 115.911466){
                                        state=WALKDN;
                                    }
                                }
                                if(SumDifIncAng > 94.999294){
                                    state=WALKDN;
                                }
                            }
                            if(SumDifIncAng > 99.618175){
                                if(SumGloAccXY <= 910.442387){
                                    state=WALKDN;
                                }
                                if(SumGloAccXY > 910.442387){
                                    state=WALKING;
                                }
                            }
                        }
                        if(SumDifAccZ > -4.64123){
                            if(SumGloGyrXY <= 50.141266){
                                if(SumGloAccXY <= 174.93966){
                                    state=STATIONARY;
                                }
                                if(SumGloAccXY > 174.93966){
                                    if(SumDifIncAng <= 95.981258){
                                        state=WALKING;
                                    }
                                    if(SumDifIncAng > 95.981258){
                                        if(SumDifIncAng <= 99.464971){
                                            if(SumDifPre <= -19.020379){
                                                state=WALKDN;
                                            }
                                            if(SumDifPre > -19.020379){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifIncAng > 99.464971){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 50.141266){
                                if(SumDifIncAng <= 98.813031){
                                    state=WALKING;
                                }
                                if(SumDifIncAng > 98.813031){
                                    if(SumGloAccXY <= 967.664823){
                                        if(SumDifAccZ <= 5.947216){
                                            if(SumGloGyrXY <= 144.594044){
                                                state=WALKING;
                                            }
                                            if(SumGloGyrXY > 144.594044){
                                                state=WALKDN;
                                            }
                                        }
                                        if(SumDifAccZ > 5.947216){
                                            state=WALKDN;
                                        }
                                    }
                                    if(SumGloAccXY > 967.664823){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                }
                if(SumDifPre > -15.135134){
                    if(SumDifPre <= 14.116604){
                        if(SumGloAccXY <= 365.85653){
                            if(SumGloAccXY <= 174.125573){
                                state=STATIONARY;
                            }
                            if(SumGloAccXY > 174.125573){
                                if(SumDifIncAng <= 98.831699){
                                    if(SumDifPre <= -9.724166){
                                        state=WALKING;
                                    }
                                    if(SumDifPre > -9.724166){
                                        if(SumGloGyrXY <= 35.685972){
                                            state=WALKING;
                                        }
                                        if(SumGloGyrXY > 35.685972){
                                            if(SumGloGyrXY <= 99.480014){
                                                state=WALKING;
                                            }
                                            if(SumGloGyrXY > 99.480014){
                                                if(SumDifIncAng <= 91.838801){
                                                    state=STATIONARY;
                                                }
                                                if(SumDifIncAng > 91.838801){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                    }
                                }
                                if(SumDifIncAng > 98.831699){
                                    state=WALKING;
                                }
                            }
                        }
                        if(SumGloAccXY > 365.85653){
                            if(SumGloGyrXY <= 83.458409){
                                if(SumDifIncAng <= 99.04533){
                                    if(SumDifPre <= -6.951298){
                                        if(SumDifAccZ <= 6.414544){
                                            if(SumGloGyrXY <= 56.705674){
                                                if(SumDifAccZ <= -0.513808){
                                                    state=WALKING;
                                                }
                                                if(SumDifAccZ > -0.513808){
                                                    if(SumDifIncAng <= 98.581405){
                                                        if(SumDifPre <= -7.545471){
                                                            if(SumGloAccXY <= 508.236513){
                                                                if(SumDifPre <= -11.701787){
                                                                    state=STATIONARY;
                                                                }
                                                                if(SumDifPre > -11.701787){
                                                                    state=WALKING;
                                                                }
                                                            }
                                                            if(SumGloAccXY > 508.236513){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(SumDifPre > -7.545471){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(SumDifIncAng > 98.581405){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                            if(SumGloGyrXY > 56.705674){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifAccZ > 6.414544){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifPre > -6.951298){
                                        state=WALKING;
                                    }
                                }
                                if(SumDifIncAng > 99.04533){
                                    state=WALKING;
                                }
                            }
                            if(SumGloGyrXY > 83.458409){
                                state=WALKING;
                            }
                        }
                    }
                    if(SumDifPre > 14.116604){
                        if(SumDifPre <= 22.206454){
                            if(SumDifAccZ <= 4.547273){
                                if(SumGloGyrXY <= 31.210398){
                                    if(SumDifIncAng <= 93.302154){
                                        state=TRANSITION;
                                    }
                                    if(SumDifIncAng > 93.302154){
                                        if(SumGloAccXY <= 191.176078){
                                            state=STATIONARY;
                                        }
                                        if(SumGloAccXY > 191.176078){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumGloGyrXY > 31.210398){
                                    if(SumDifIncAng <= 97.748955){
                                        if(SumGloGyrXY <= 75.656151){
                                            state=WALKING;
                                        }
                                        if(SumGloGyrXY > 75.656151){
                                            if(SumGloAccXY <= 710.065108){
                                                state=WALKUP;
                                            }
                                            if(SumGloAccXY > 710.065108){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                    if(SumDifIncAng > 97.748955){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumDifAccZ > 4.547273){
                                if(SumGloGyrXY <= 41.928984){
                                    state=STATIONARY;
                                }
                                if(SumGloGyrXY > 41.928984){
                                    if(SumGloAccXY <= 1445.092892){
                                        if(SumGloGyrXY <= 133.111321){
                                            if(SumGloAccXY <= 388.532024){
                                                state=WALKUP;
                                            }
                                            if(SumGloAccXY > 388.532024){
                                                if(SumGloGyrXY <= 89.049751){
                                                    state=WALKING;
                                                }
                                                if(SumGloGyrXY > 89.049751){
                                                    if(SumDifPre <= 14.908743){
                                                        state=WALKING;
                                                    }
                                                    if(SumDifPre > 14.908743){
                                                        state=WALKUP;
                                                    }
                                                }
                                            }
                                        }
                                        if(SumGloGyrXY > 133.111321){
                                            state=WALKUP;
                                        }
                                    }
                                    if(SumGloAccXY > 1445.092892){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                        if(SumDifPre > 22.206454){
                            if(SumGloGyrXY <= 85.373798){
                                if(SumGloGyrXY <= 35.162921){
                                    if(SumDifPre <= 27.201233){
                                        state=WALKING;
                                    }
                                    if(SumDifPre > 27.201233){
                                        state=STATIONARY;
                                    }
                                }
                                if(SumGloGyrXY > 35.162921){
                                    if(SumGloGyrXY <= 66.492891){
                                        state=WALKING;
                                    }
                                    if(SumGloGyrXY > 66.492891){
                                        if(SumGloAccXY <= 538.424032){
                                            state=WALKUP;
                                        }
                                        if(SumGloAccXY > 538.424032){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 85.373798){
                                if(SumDifIncAng <= 99.385746){
                                    if(SumGloAccXY <= 571.309799){
                                        state=WALKUP;
                                    }
                                    if(SumGloAccXY > 571.309799){
                                        if(SumGloGyrXY <= 171.074529){
                                            if(SumGloAccXY <= 1232.491624){
                                                state=WALKUP;
                                            }
                                            if(SumGloAccXY > 1232.491624){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumGloGyrXY > 171.074529){
                                            if(SumGloAccXY <= 2425.949455){
                                                state=WALKUP;
                                            }
                                            if(SumGloAccXY > 2425.949455){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                                if(SumDifIncAng > 99.385746){
                                    if(SumGloAccXY <= 1070.557592){
                                        state=WALKUP;
                                    }
                                    if(SumGloAccXY > 1070.557592){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return state;
    }

    protected int classifyFourFeatures(double SumGloAccXY, double SumGloGyrXY, double SumDifPre, double SumDifIncAng){
        state = -1;
        if(SumGloGyrXY <= 22.383355){
            if(SumGloGyrXY <= 3.484977){
                state=STATIONARY;
            }
            if(SumGloGyrXY > 3.484977){
                if(SumDifIncAng <= 95.677857){
                    if(SumGloAccXY <= 70.8785){
                        if(SumDifIncAng <= 81.37962){
                            if(SumGloAccXY <= 10.348496){
                                state=STATIONARY;
                            }
                            if(SumGloAccXY > 10.348496){
                                state=TRANSITION;
                            }
                        }
                        if(SumDifIncAng > 81.37962){
                            state=STATIONARY;
                        }
                    }
                    if(SumGloAccXY > 70.8785){
                        if(SumDifPre <= -8.49742){
                            if(SumDifIncAng <= 92.384162){
                                state=STATIONARY;
                            }
                            if(SumDifIncAng > 92.384162){
                                if(SumGloAccXY <= 275.272765){
                                    if(SumDifPre <= -10.834075){
                                        if(SumGloGyrXY <= 12.208026){
                                            state=STATIONARY;
                                        }
                                        if(SumGloGyrXY > 12.208026){
                                            state=WALKDN;
                                        }
                                    }
                                    if(SumDifPre > -10.834075){
                                        if(SumDifIncAng <= 94.593999){
                                            state=TRANSITION;
                                        }
                                        if(SumDifIncAng > 94.593999){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                                if(SumGloAccXY > 275.272765){
                                    state=STATIONARY;
                                }
                            }
                        }
                        if(SumDifPre > -8.49742){
                            if(SumDifIncAng <= 88.713879){
                                state=STATIONARY;
                            }
                            if(SumDifIncAng > 88.713879){
                                if(SumGloAccXY <= 1470.506739){
                                    if(SumGloGyrXY <= 18.755348){
                                        state=STATIONARY;
                                    }
                                    if(SumGloGyrXY > 18.755348){
                                        if(SumDifIncAng <= 95.416294){
                                            state=STATIONARY;
                                        }
                                        if(SumDifIncAng > 95.416294){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumGloAccXY > 1470.506739){
                                    state=STATIONARY;
                                }
                            }
                        }
                    }
                }
                if(SumDifIncAng > 95.677857){
                    if(SumGloGyrXY <= 9.281273){
                        state=STATIONARY;
                    }
                    if(SumGloGyrXY > 9.281273){
                        if(SumGloAccXY <= 96.817132){
                            if(SumGloAccXY <= 69.360379){
                                state=STATIONARY;
                            }
                            if(SumGloAccXY > 69.360379){
                                if(SumGloAccXY <= 89.140988){
                                    if(SumDifPre <= 0.792566){
                                        if(SumGloAccXY <= 80.68738){
                                            state=STATIONARY;
                                        }
                                        if(SumGloAccXY > 80.68738){
                                            if(SumGloGyrXY <= 14.200991){
                                                if(SumGloGyrXY <= 10.356897){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloGyrXY > 10.356897){
                                                    if(SumGloGyrXY <= 11.535386){
                                                        state=WALKING;
                                                    }
                                                    if(SumGloGyrXY > 11.535386){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                            if(SumGloGyrXY > 14.200991){
                                                state=STATIONARY;
                                            }
                                        }
                                    }
                                    if(SumDifPre > 0.792566){
                                        state=STATIONARY;
                                    }
                                }
                                if(SumGloAccXY > 89.140988){
                                    state=STATIONARY;
                                }
                            }
                        }
                        if(SumGloAccXY > 96.817132){
                            state=STATIONARY;
                        }
                    }
                }
            }
        }
        if(SumGloGyrXY > 22.383355){
            if(SumDifIncAng <= 88.186386){
                if(SumGloAccXY <= 516.152923){
                    if(SumDifIncAng <= 69.706513){
                        if(SumGloAccXY <= 193.459843){
                            if(SumDifIncAng <= 54.234206){
                                state=TRANSITION;
                            }
                            if(SumDifIncAng > 54.234206){
                                if(SumGloGyrXY <= 76.654051){
                                    state=TRANSITION;
                                }
                                if(SumGloGyrXY > 76.654051){
                                    if(SumDifPre <= 12.594001){
                                        if(SumGloAccXY <= 136.270934){
                                            if(SumGloAccXY <= 78.668537){
                                                state=TRANSITION;
                                            }
                                            if(SumGloAccXY > 78.668537){
                                                if(SumGloGyrXY <= 86.352416){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloGyrXY > 86.352416){
                                                    state=TRANSITION;
                                                }
                                            }
                                        }
                                        if(SumGloAccXY > 136.270934){
                                            if(SumDifPre <= -5.575138){
                                                state=STATIONARY;
                                            }
                                            if(SumDifPre > -5.575138){
                                                state=TRANSITION;
                                            }
                                        }
                                    }
                                    if(SumDifPre > 12.594001){
                                        state=WALKUP;
                                    }
                                }
                            }
                        }
                        if(SumGloAccXY > 193.459843){
                            if(SumDifPre <= -0.008274){
                                state=TRANSITION;
                            }
                            if(SumDifPre > -0.008274){
                                if(SumDifIncAng <= 49.669186){
                                    state=TRANSITION;
                                }
                                if(SumDifIncAng > 49.669186){
                                    if(SumGloGyrXY <= 177.972009){
                                        state=TRANSITION;
                                    }
                                    if(SumGloGyrXY > 177.972009){
                                        state=STATIONARY;
                                    }
                                }
                            }
                        }
                    }
                    if(SumDifIncAng > 69.706513){
                        if(SumDifPre <= 11.030753){
                            if(SumGloAccXY <= 186.725094){
                                if(SumGloGyrXY <= 57.640622){
                                    if(SumGloAccXY <= 99.080726){
                                        state=TRANSITION;
                                    }
                                    if(SumGloAccXY > 99.080726){
                                        state=STATIONARY;
                                    }
                                }
                                if(SumGloGyrXY > 57.640622){
                                    state=STATIONARY;
                                }
                            }
                            if(SumGloAccXY > 186.725094){
                                if(SumDifPre <= 3.712644){
                                    state=TRANSITION;
                                }
                                if(SumDifPre > 3.712644){
                                    if(SumGloGyrXY <= 88.633401){
                                        state=TRANSITION;
                                    }
                                    if(SumGloGyrXY > 88.633401){
                                        if(SumDifIncAng <= 76.212977){
                                            state=WALKING;
                                        }
                                        if(SumDifIncAng > 76.212977){
                                            if(SumGloAccXY <= 354.177818){
                                                state=WALKUP;
                                            }
                                            if(SumGloAccXY > 354.177818){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(SumDifPre > 11.030753){
                            if(SumGloGyrXY <= 48.799863){
                                if(SumDifPre <= 16.961869){
                                    state=STATIONARY;
                                }
                                if(SumDifPre > 16.961869){
                                    state=TRANSITION;
                                }
                            }
                            if(SumGloGyrXY > 48.799863){
                                state=WALKUP;
                            }
                        }
                    }
                }
                if(SumGloAccXY > 516.152923){
                    if(SumDifPre <= 14.435589){
                        if(SumDifIncAng <= 63.849976){
                            if(SumGloAccXY <= 1557.348131){
                                if(SumGloGyrXY <= 48.365892){
                                    state=STATIONARY;
                                }
                                if(SumGloGyrXY > 48.365892){
                                    if(SumDifPre <= 3.117667){
                                        state=TRANSITION;
                                    }
                                    if(SumDifPre > 3.117667){
                                        if(SumGloGyrXY <= 245.212059){
                                            state=WALKING;
                                        }
                                        if(SumGloGyrXY > 245.212059){
                                            state=TRANSITION;
                                        }
                                    }
                                }
                            }
                            if(SumGloAccXY > 1557.348131){
                                if(SumGloGyrXY <= 66.086999){
                                    if(SumDifPre <= -0.855678){
                                        if(SumGloGyrXY <= 29.145049){
                                            if(SumGloAccXY <= 5215.944814){
                                                if(SumDifPre <= -7.338329){
                                                    state=WALKING;
                                                }
                                                if(SumDifPre > -7.338329){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(SumGloAccXY > 5215.944814){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SumGloGyrXY > 29.145049){
                                            state=TRANSITION;
                                        }
                                    }
                                    if(SumDifPre > -0.855678){
                                        state=STATIONARY;
                                    }
                                }
                                if(SumGloGyrXY > 66.086999){
                                    if(SumDifPre <= -6.28132){
                                        if(SumDifIncAng <= 30.656107){
                                            state=TRANSITION;
                                        }
                                        if(SumDifIncAng > 30.656107){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifPre > -6.28132){
                                        if(SumGloAccXY <= 4656.327721){
                                            if(SumDifPre <= 9.038232){
                                                state=WALKING;
                                            }
                                            if(SumDifPre > 9.038232){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SumGloAccXY > 4656.327721){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                        }
                        if(SumDifIncAng > 63.849976){
                            if(SumGloGyrXY <= 98.170969){
                                if(SumDifPre <= -7.114641){
                                    if(SumDifIncAng <= 68.729082){
                                        state=TRANSITION;
                                    }
                                    if(SumDifIncAng > 68.729082){
                                        state=WALKING;
                                    }
                                }
                                if(SumDifPre > -7.114641){
                                    if(SumGloGyrXY <= 60.218874){
                                        state=STATIONARY;
                                    }
                                    if(SumGloGyrXY > 60.218874){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(SumGloGyrXY > 98.170969){
                                if(SumDifPre <= -13.934576){
                                    state=WALKING;
                                }
                                if(SumDifPre > -13.934576){
                                    if(SumGloAccXY <= 1207.53601){
                                        if(SumDifPre <= 2.755046){
                                            if(SumDifIncAng <= 80.863473){
                                                if(SumGloGyrXY <= 105.804126){
                                                    if(SumDifPre <= -1.137797){
                                                        state=WALKING;
                                                    }
                                                    if(SumDifPre > -1.137797){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(SumGloGyrXY > 105.804126){
                                                    if(SumGloAccXY <= 592.981185){
                                                        if(SumGloGyrXY <= 166.381331){
                                                            state=WALKING;
                                                        }
                                                        if(SumGloGyrXY > 166.381331){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(SumGloAccXY > 592.981185){
                                                        if(SumGloGyrXY <= 208.268748){
                                                            if(SumDifIncAng <= 73.839908){
                                                                state=TRANSITION;
                                                            }
                                                            if(SumDifIncAng > 73.839908){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(SumGloGyrXY > 208.268748){
                                                            state=WALKING;
                                                        }
                                                    }
                                                }
                                            }
                                            if(SumDifIncAng > 80.863473){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifPre > 2.755046){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumGloAccXY > 1207.53601){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                    if(SumDifPre > 14.435589){
                        if(SumGloGyrXY <= 143.355066){
                            state=WALKING;
                        }
                        if(SumGloGyrXY > 143.355066){
                            state=WALKUP;
                        }
                    }
                }
            }
            if(SumDifIncAng > 88.186386){
                if(SumDifPre <= -14.660355){
                    if(SumDifPre <= -23.87996){
                        state=WALKDN;
                    }
                    if(SumDifPre > -23.87996){
                        if(SumGloGyrXY <= 62.265519){
                            if(SumDifIncAng <= 91.890521){
                                state=STATIONARY;
                            }
                            if(SumDifIncAng > 91.890521){
                                if(SumGloAccXY <= 108.281421){
                                    state=STATIONARY;
                                }
                                if(SumGloAccXY > 108.281421){
                                    state=WALKING;
                                }
                            }
                        }
                        if(SumGloGyrXY > 62.265519){
                            if(SumDifIncAng <= 99.384353){
                                if(SumGloAccXY <= 1473.388654){
                                    if(SumDifPre <= -21.585857){
                                        if(SumDifIncAng <= 95.83101){
                                            state=WALKING;
                                        }
                                        if(SumDifIncAng > 95.83101){
                                            state=WALKDN;
                                        }
                                    }
                                    if(SumDifPre > -21.585857){
                                        state=WALKING;
                                    }
                                }
                                if(SumGloAccXY > 1473.388654){
                                    state=WALKING;
                                }
                            }
                            if(SumDifIncAng > 99.384353){
                                state=WALKING;
                            }
                        }
                    }
                }
                if(SumDifPre > -14.660355){
                    if(SumDifPre <= 14.117962){
                        if(SumGloAccXY <= 362.438004){
                            if(SumGloAccXY <= 134.959362){
                                state=STATIONARY;
                            }
                            if(SumGloAccXY > 134.959362){
                                if(SumDifIncAng <= 98.197353){
                                    if(SumDifIncAng <= 94.283832){
                                        if(SumDifPre <= -9.334553){
                                            state=WALKING;
                                        }
                                        if(SumDifPre > -9.334553){
                                            if(SumGloGyrXY <= 92.531367){
                                                if(SumGloAccXY <= 264.340847){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloAccXY > 264.340847){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumGloGyrXY > 92.531367){
                                                if(SumGloGyrXY <= 105.943401){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloGyrXY > 105.943401){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                    }
                                    if(SumDifIncAng > 94.283832){
                                        state=WALKING;
                                    }
                                }
                                if(SumDifIncAng > 98.197353){
                                    if(SumGloGyrXY <= 33.583567){
                                        if(SumDifPre <= -1.190885){
                                            if(SumGloAccXY <= 174.094094){
                                                state=STATIONARY;
                                            }
                                            if(SumGloAccXY > 174.094094){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifPre > -1.190885){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumGloGyrXY > 33.583567){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                        if(SumGloAccXY > 362.438004){
                            if(SumGloGyrXY <= 67.852113){
                                if(SumDifIncAng <= 99.367443){
                                    if(SumDifPre <= -6.467126){
                                        state=WALKING;
                                    }
                                    if(SumDifPre > -6.467126){
                                        if(SumGloGyrXY <= 52.958505){
                                            if(SumDifIncAng <= 94.650536){
                                                if(SumGloAccXY <= 3838.433593){
                                                    state=WALKING;
                                                }
                                                if(SumGloAccXY > 3838.433593){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(SumDifIncAng > 94.650536){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumGloGyrXY > 52.958505){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifIncAng > 99.367443){
                                    state=WALKING;
                                }
                            }
                            if(SumGloGyrXY > 67.852113){
                                state=WALKING;
                            }
                        }
                    }
                    if(SumDifPre > 14.117962){
                        if(SumGloGyrXY <= 64.61461){
                            if(SumDifIncAng <= 93.085106){
                                state=WALKING;
                            }
                            if(SumDifIncAng > 93.085106){
                                if(SumGloAccXY <= 171.732303){
                                    state=STATIONARY;
                                }
                                if(SumGloAccXY > 171.732303){
                                    state=WALKING;
                                }
                            }
                        }
                        if(SumGloGyrXY > 64.61461){
                            if(SumDifIncAng <= 99.155963){
                                if(SumDifPre <= 19.977614){
                                    if(SumDifIncAng <= 98.711148){
                                        if(SumGloAccXY <= 1171.817024){
                                            if(SumGloGyrXY <= 97.179045){
                                                state=WALKING;
                                            }
                                            if(SumGloGyrXY > 97.179045){
                                                state=WALKUP;
                                            }
                                        }
                                        if(SumGloAccXY > 1171.817024){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifIncAng > 98.711148){
                                        state=WALKING;
                                    }
                                }
                                if(SumDifPre > 19.977614){
                                    if(SumDifPre <= 28.457613){
                                        if(SumGloAccXY <= 669.019777){
                                            state=WALKUP;
                                        }
                                        if(SumGloAccXY > 669.019777){
                                            if(SumGloGyrXY <= 162.63113){
                                                if(SumDifIncAng <= 96.898016){
                                                    state=WALKING;
                                                }
                                                if(SumDifIncAng > 96.898016){
                                                    if(SumDifPre <= 25.979641){
                                                        if(SumDifPre <= 24.332795){
                                                            state=WALKING;
                                                        }
                                                        if(SumDifPre > 24.332795){
                                                            state=WALKUP;
                                                        }
                                                    }
                                                    if(SumDifPre > 25.979641){
                                                        state=WALKING;
                                                    }
                                                }
                                            }
                                            if(SumGloGyrXY > 162.63113){
                                                state=WALKUP;
                                            }
                                        }
                                    }
                                    if(SumDifPre > 28.457613){
                                        state=WALKUP;
                                    }
                                }
                            }
                            if(SumDifIncAng > 99.155963){
                                if(SumDifPre <= 29.00131){
                                    if(SumGloAccXY <= 670.855406){
                                        if(SumDifPre <= 18.589508){
                                            state=WALKING;
                                        }
                                        if(SumDifPre > 18.589508){
                                            state=WALKUP;
                                        }
                                    }
                                    if(SumGloAccXY > 670.855406){
                                        state=WALKING;
                                    }
                                }
                                if(SumDifPre > 29.00131){
                                    if(SumGloAccXY <= 1796.064618){
                                        state=WALKUP;
                                    }
                                    if(SumGloAccXY > 1796.064618){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return state;
    }

    protected static int classifyCombined(double SumGloGyrXY, double SumGloAccXY, double SumDifIncAng, double SumDifPre, double SumDifAccZ){
        int state = -1;
        if(SumGloGyrXY <= 22.383355){
            if(SumGloGyrXY <= 3.484977){
                state=STATIONARY;
            }
            if(SumGloGyrXY > 3.484977){
                if(SumDifIncAng <= 95.677857){
                    if(SumGloAccXY <= 70.8785){
                        if(SumDifIncAng <= 81.37962){
                            if(SumGloAccXY <= 10.348496){
                                state=STATIONARY;
                            }
                            if(SumGloAccXY > 10.348496){
                                state=TRANSITION;
                            }
                        }
                        if(SumDifIncAng > 81.37962){
                            state=STATIONARY;
                        }
                    }
                    if(SumGloAccXY > 70.8785){
                        if(SumDifPre <= -8.49742){
                            state=STATIONARY;
                        }
                        if(SumDifPre > -8.49742){
                            if(SumDifAccZ <= 52.607045){
                                if(SumGloGyrXY <= 12.135785){
                                    state=STATIONARY;
                                }
                                if(SumGloGyrXY > 12.135785){
                                    if(SumDifIncAng <= 90.737698){
                                        if(SumDifPre <= 20.545626){
                                            if(SumDifIncAng <= 60.532928){
                                                state=WALKING;
                                            }
                                            if(SumDifIncAng > 60.532928){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SumDifPre > 20.545626){
                                            state=TRANSITION;
                                        }
                                    }
                                    if(SumDifIncAng > 90.737698){
                                        state=STATIONARY;
                                    }
                                }
                            }
                            if(SumDifAccZ > 52.607045){
                                if(SumGloAccXY <= 504.893966){
                                    if(SumDifIncAng <= 94.335612){
                                        state=WALKING;
                                    }
                                    if(SumDifIncAng > 94.335612){
                                        state=STATIONARY;
                                    }
                                }
                                if(SumGloAccXY > 504.893966){
                                    if(SumGloGyrXY <= 11.060724){
                                        state=STATIONARY;
                                    }
                                    if(SumGloGyrXY > 11.060724){
                                        if(SumDifAccZ <= 58.174587){
                                            state=WALKING;
                                        }
                                        if(SumDifAccZ > 58.174587){
                                            if(SumDifAccZ <= 184.43081){
                                                state=STATIONARY;
                                            }
                                            if(SumDifAccZ > 184.43081){
                                                if(SumDifAccZ <= 296.512468){
                                                    state=STATIONARY;
                                                }
                                                if(SumDifAccZ > 296.512468){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(SumDifIncAng > 95.677857){
                    state=STATIONARY;
                }
            }
        }
        if(SumGloGyrXY > 22.383355){
            if(SumDifIncAng <= 88.186386){
                if(SumGloAccXY <= 516.152923){
                    if(SumDifIncAng <= 69.706513){
                        if(SumGloAccXY <= 193.459843){
                            if(SumDifIncAng <= 54.234206){
                                state=TRANSITION;
                            }
                            if(SumDifIncAng > 54.234206){
                                if(SumGloGyrXY <= 76.654051){
                                    state=TRANSITION;
                                }
                                if(SumGloGyrXY > 76.654051){
                                    if(SumDifPre <= 12.594001){
                                        if(SumGloAccXY <= 136.270934){
                                            if(SumGloAccXY <= 78.668537){
                                                state=TRANSITION;
                                            }
                                            if(SumGloAccXY > 78.668537){
                                                if(SumGloGyrXY <= 86.352416){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloGyrXY > 86.352416){
                                                    state=TRANSITION;
                                                }
                                            }
                                        }
                                        if(SumGloAccXY > 136.270934){
                                            if(SumDifPre <= -5.575138){
                                                state=STATIONARY;
                                            }
                                            if(SumDifPre > -5.575138){
                                                state=TRANSITION;
                                            }
                                        }
                                    }
                                    if(SumDifPre > 12.594001){
                                        state=WALKUP;
                                    }
                                }
                            }
                        }
                        if(SumGloAccXY > 193.459843){
                            if(SumDifPre <= -0.008274){
                                state=TRANSITION;
                            }
                            if(SumDifPre > -0.008274){
                                if(SumDifIncAng <= 49.669186){
                                    if(SumGloAccXY <= 324.703841){
                                        if(SumDifIncAng <= 17.77117){
                                            state=TRANSITION;
                                        }
                                        if(SumDifIncAng > 17.77117){
                                            if(SumDifAccZ <= 25.572034){
                                                state=TRANSITION;
                                            }
                                            if(SumDifAccZ > 25.572034){
                                                if(SumDifIncAng <= 44.461516){
                                                    state=TRANSITION;
                                                }
                                                if(SumDifIncAng > 44.461516){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                    }
                                    if(SumGloAccXY > 324.703841){
                                        state=TRANSITION;
                                    }
                                }
                                if(SumDifIncAng > 49.669186){
                                    if(SumGloGyrXY <= 177.972009){
                                        state=TRANSITION;
                                    }
                                    if(SumGloGyrXY > 177.972009){
                                        state=STATIONARY;
                                    }
                                }
                            }
                        }
                    }
                    if(SumDifIncAng > 69.706513){
                        if(SumDifPre <= 11.030753){
                            if(SumGloAccXY <= 186.725094){
                                if(SumGloGyrXY <= 57.640622){
                                    if(SumGloAccXY <= 99.080726){
                                        state=TRANSITION;
                                    }
                                    if(SumGloAccXY > 99.080726){
                                        if(SumDifAccZ <= -0.03424){
                                            state=STATIONARY;
                                        }
                                        if(SumDifAccZ > -0.03424){
                                            if(SumDifPre <= -19.240291){
                                                state=WALKDN;
                                            }
                                            if(SumDifPre > -19.240291){
                                                if(SumDifAccZ <= 25.541453){
                                                    state=TRANSITION;
                                                }
                                                if(SumDifAccZ > 25.541453){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                    }
                                }
                                if(SumGloGyrXY > 57.640622){
                                    state=STATIONARY;
                                }
                            }
                            if(SumGloAccXY > 186.725094){
                                if(SumDifPre <= 3.712644){
                                    state=TRANSITION;
                                }
                                if(SumDifPre > 3.712644){
                                    if(SumGloGyrXY <= 88.633401){
                                        state=TRANSITION;
                                    }
                                    if(SumGloGyrXY > 88.633401){
                                        if(SumDifIncAng <= 76.212977){
                                            state=WALKING;
                                        }
                                        if(SumDifIncAng > 76.212977){
                                            if(SumGloAccXY <= 354.177818){
                                                state=WALKUP;
                                            }
                                            if(SumGloAccXY > 354.177818){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(SumDifPre > 11.030753){
                            if(SumGloGyrXY <= 48.799863){
                                if(SumDifPre <= 16.961869){
                                    state=STATIONARY;
                                }
                                if(SumDifPre > 16.961869){
                                    state=TRANSITION;
                                }
                            }
                            if(SumGloGyrXY > 48.799863){
                                state=WALKUP;
                            }
                        }
                    }
                }
                if(SumGloAccXY > 516.152923){
                    if(SumDifPre <= 14.435589){
                        if(SumDifIncAng <= 63.849976){
                            if(SumDifAccZ <= 73.691882){
                                if(SumGloAccXY <= 3623.031018){
                                    if(SumDifPre <= -0.71413){
                                        if(SumDifIncAng <= 44.257912){
                                            state=TRANSITION;
                                        }
                                        if(SumDifIncAng > 44.257912){
                                            if(SumDifIncAng <= 62.019593){
                                                if(SumGloGyrXY <= 24.686762){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloGyrXY > 24.686762){
                                                    if(SumDifPre <= -4.13332){
                                                        if(SumDifPre <= -6.672147){
                                                            state=TRANSITION;
                                                        }
                                                        if(SumDifPre > -6.672147){
                                                            state=WALKING;
                                                        }
                                                    }
                                                    if(SumDifPre > -4.13332){
                                                        state=TRANSITION;
                                                    }
                                                }
                                            }
                                            if(SumDifIncAng > 62.019593){
                                                if(SumDifIncAng <= 62.58363){
                                                    state=WALKING;
                                                }
                                                if(SumDifIncAng > 62.58363){
                                                    if(SumDifAccZ <= -35.607537){
                                                        state=WALKING;
                                                    }
                                                    if(SumDifAccZ > -35.607537){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if(SumDifPre > -0.71413){
                                        if(SumGloGyrXY <= 50.300577){
                                            state=TRANSITION;
                                        }
                                        if(SumGloGyrXY > 50.300577){
                                            if(SumDifAccZ <= -49.597759){
                                                state=TRANSITION;
                                            }
                                            if(SumDifAccZ > -49.597759){
                                                if(SumDifIncAng <= 8.734149){
                                                    state=TRANSITION;
                                                }
                                                if(SumDifIncAng > 8.734149){
                                                    if(SumGloAccXY <= 1473.66749){
                                                        state=TRANSITION;
                                                    }
                                                    if(SumGloAccXY > 1473.66749){
                                                        state=WALKING;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if(SumGloAccXY > 3623.031018){
                                    if(SumDifIncAng <= 24.198984){
                                        if(SumGloAccXY <= 9063.987364){
                                            state=TRANSITION;
                                        }
                                        if(SumGloAccXY > 9063.987364){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifIncAng > 24.198984){
                                        if(SumGloGyrXY <= 124.603654){
                                            if(SumGloAccXY <= 8777.921578){
                                                if(SumDifPre <= 3.470468){
                                                    if(SumDifAccZ <= -190.527413){
                                                        state=STATIONARY;
                                                    }
                                                    if(SumDifAccZ > -190.527413){
                                                        if(SumGloGyrXY <= 39.95438){
                                                            state=STATIONARY;
                                                        }
                                                        if(SumGloGyrXY > 39.95438){
                                                            if(SumGloGyrXY <= 102.169897){
                                                                state=WALKING;
                                                            }
                                                            if(SumGloGyrXY > 102.169897){
                                                                state=TRANSITION;
                                                            }
                                                        }
                                                    }
                                                }
                                                if(SumDifPre > 3.470468){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumGloAccXY > 8777.921578){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SumGloGyrXY > 124.603654){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                            if(SumDifAccZ > 73.691882){
                                if(SumDifPre <= -4.700961){
                                    if(SumGloGyrXY <= 28.847001){
                                        state=WALKING;
                                    }
                                    if(SumGloGyrXY > 28.847001){
                                        if(SumGloGyrXY <= 48.861723){
                                            state=TRANSITION;
                                        }
                                        if(SumGloGyrXY > 48.861723){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifPre > -4.700961){
                                    if(SumGloGyrXY <= 62.578047){
                                        if(SumGloAccXY <= 1838.570104){
                                            state=WALKING;
                                        }
                                        if(SumGloAccXY > 1838.570104){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SumGloGyrXY > 62.578047){
                                        if(SumDifPre <= 8.656094){
                                            if(SumGloAccXY <= 3813.351684){
                                                if(SumDifPre <= 0.05994){
                                                    if(SumGloAccXY <= 3304.188511){
                                                        state=WALKING;
                                                    }
                                                    if(SumGloAccXY > 3304.188511){
                                                        if(SumGloAccXY <= 3621.335286){
                                                            state=STATIONARY;
                                                        }
                                                        if(SumGloAccXY > 3621.335286){
                                                            state=WALKING;
                                                        }
                                                    }
                                                }
                                                if(SumDifPre > 0.05994){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumGloAccXY > 3813.351684){
                                                if(SumDifAccZ <= 468.675303){
                                                    state=WALKING;
                                                }
                                                if(SumDifAccZ > 468.675303){
                                                    if(SumDifIncAng <= 13.110286){
                                                        state=WALKING;
                                                    }
                                                    if(SumDifIncAng > 13.110286){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                        if(SumDifPre > 8.656094){
                                            if(SumDifPre <= 12.037598){
                                                state=STATIONARY;
                                            }
                                            if(SumDifPre > 12.037598){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(SumDifIncAng > 63.849976){
                            if(SumGloGyrXY <= 98.170969){
                                if(SumDifPre <= -7.114641){
                                    if(SumDifAccZ <= 6.588513){
                                        state=WALKING;
                                    }
                                    if(SumDifAccZ > 6.588513){
                                        if(SumDifIncAng <= 80.915034){
                                            if(SumGloGyrXY <= 49.449148){
                                                state=TRANSITION;
                                            }
                                            if(SumGloGyrXY > 49.449148){
                                                if(SumGloAccXY <= 1569.852142){
                                                    state=TRANSITION;
                                                }
                                                if(SumGloAccXY > 1569.852142){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifIncAng > 80.915034){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifPre > -7.114641){
                                    if(SumGloGyrXY <= 60.218874){
                                        if(SumDifAccZ <= -30.789582){
                                            state=STATIONARY;
                                        }
                                        if(SumDifAccZ > -30.789582){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumGloGyrXY > 60.218874){
                                        if(SumGloAccXY <= 726.304819){
                                            if(SumGloAccXY <= 693.084274){
                                                state=WALKING;
                                            }
                                            if(SumGloAccXY > 693.084274){
                                                state=TRANSITION;
                                            }
                                        }
                                        if(SumGloAccXY > 726.304819){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 98.170969){
                                if(SumDifPre <= -13.934576){
                                    state=WALKING;
                                }
                                if(SumDifPre > -13.934576){
                                    if(SumGloAccXY <= 1207.53601){
                                        if(SumDifPre <= 2.755046){
                                            if(SumDifIncAng <= 80.863473){
                                                if(SumGloGyrXY <= 105.804126){
                                                    if(SumDifPre <= -1.137797){
                                                        state=WALKING;
                                                    }
                                                    if(SumDifPre > -1.137797){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(SumGloGyrXY > 105.804126){
                                                    if(SumGloAccXY <= 592.981185){
                                                        if(SumGloGyrXY <= 166.381331){
                                                            state=WALKING;
                                                        }
                                                        if(SumGloGyrXY > 166.381331){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(SumGloAccXY > 592.981185){
                                                        if(SumGloGyrXY <= 208.268748){
                                                            if(SumDifIncAng <= 73.839908){
                                                                state=TRANSITION;
                                                            }
                                                            if(SumDifIncAng > 73.839908){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(SumGloGyrXY > 208.268748){
                                                            state=WALKING;
                                                        }
                                                    }
                                                }
                                            }
                                            if(SumDifIncAng > 80.863473){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifPre > 2.755046){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumGloAccXY > 1207.53601){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                    if(SumDifPre > 14.435589){
                        if(SumGloGyrXY <= 143.355066){
                            state=WALKING;
                        }
                        if(SumGloGyrXY > 143.355066){
                            state=WALKUP;
                        }
                    }
                }
            }
            if(SumDifIncAng > 88.186386){
                if(SumDifPre <= -14.660355){
                    if(SumDifPre <= -23.87996){
                        if(SumDifPre <= -58.306361){
                            if(SumGloGyrXY <= 57.854032){
                                state=STATIONARY;
                            }
                            if(SumGloGyrXY > 57.854032){
                                state=WALKING;
                            }
                        }
                        if(SumDifPre > -58.306361){
                            if(SumGloAccXY <= 310.334429){
                                if(SumDifAccZ <= 2.133152){
                                    state=WALKDN;
                                }
                                if(SumDifAccZ > 2.133152){
                                    state=WALKING;
                                }
                            }
                            if(SumGloAccXY > 310.334429){
                                state=WALKDN;
                            }
                        }
                    }
                    if(SumDifPre > -23.87996){
                        if(SumDifAccZ <= -4.197963){
                            if(SumGloAccXY <= 999.501552){
                                if(SumGloAccXY <= 175.820052){
                                    state=WALKING;
                                }
                                if(SumGloAccXY > 175.820052){
                                    if(SumDifIncAng <= 95.239933){
                                        state=WALKING;
                                    }
                                    if(SumDifIncAng > 95.239933){
                                        state=WALKDN;
                                    }
                                }
                            }
                            if(SumGloAccXY > 999.501552){
                                if(SumDifIncAng <= 98.047262){
                                    state=WALKDN;
                                }
                                if(SumDifIncAng > 98.047262){
                                    state=WALKING;
                                }
                            }
                        }
                        if(SumDifAccZ > -4.197963){
                            if(SumGloGyrXY <= 51.587577){
                                if(SumDifIncAng <= 92.133437){
                                    if(SumGloAccXY <= 202.599049){
                                        state=STATIONARY;
                                    }
                                    if(SumGloAccXY > 202.599049){
                                        state=TRANSITION;
                                    }
                                }
                                if(SumDifIncAng > 92.133437){
                                    if(SumGloAccXY <= 99.533797){
                                        state=STATIONARY;
                                    }
                                    if(SumGloAccXY > 99.533797){
                                        if(SumDifPre <= -19.75044){
                                            if(SumDifAccZ <= 4.740589){
                                                state=WALKING;
                                            }
                                            if(SumDifAccZ > 4.740589){
                                                if(SumDifAccZ <= 11.822923){
                                                    state=WALKDN;
                                                }
                                                if(SumDifAccZ > 11.822923){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifPre > -19.75044){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                            if(SumGloGyrXY > 51.587577){
                                if(SumDifIncAng <= 98.916043){
                                    if(SumDifPre <= -17.842608){
                                        if(SumGloAccXY <= 2112.388859){
                                            if(SumGloAccXY <= 953.601657){
                                                state=WALKING;
                                            }
                                            if(SumGloAccXY > 953.601657){
                                                if(SumGloAccXY <= 1363.806092){
                                                    state=WALKDN;
                                                }
                                                if(SumGloAccXY > 1363.806092){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumGloAccXY > 2112.388859){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifPre > -17.842608){
                                        state=WALKING;
                                    }
                                }
                                if(SumDifIncAng > 98.916043){
                                    state=WALKING;
                                }
                            }
                        }
                    }
                }
                if(SumDifPre > -14.660355){
                    if(SumDifPre <= 14.117962){
                        if(SumGloAccXY <= 362.438004){
                            if(SumGloAccXY <= 134.959362){
                                if(SumDifIncAng <= 93.949722){
                                    state=STATIONARY;
                                }
                                if(SumDifIncAng > 93.949722){
                                    if(SumGloAccXY <= 83.517737){
                                        if(SumDifAccZ <= 8.186059){
                                            state=STATIONARY;
                                        }
                                        if(SumDifAccZ > 8.186059){
                                            if(SumGloAccXY <= 49.056807){
                                                state=STATIONARY;
                                            }
                                            if(SumGloAccXY > 49.056807){
                                                state=TRANSITION;
                                            }
                                        }
                                    }
                                    if(SumGloAccXY > 83.517737){
                                        state=STATIONARY;
                                    }
                                }
                            }
                            if(SumGloAccXY > 134.959362){
                                if(SumDifIncAng <= 98.197353){
                                    if(SumDifPre <= -6.770891){
                                        if(SumDifAccZ <= 3.930263){
                                            if(SumGloAccXY <= 358.28719){
                                                if(SumDifIncAng <= 94.164899){
                                                    if(SumDifAccZ <= 0.083135){
                                                        if(SumDifIncAng <= 88.853916){
                                                            state=TRANSITION;
                                                        }
                                                        if(SumDifIncAng > 88.853916){
                                                            if(SumGloAccXY <= 207.931709){
                                                                state=STATIONARY;
                                                            }
                                                            if(SumGloAccXY > 207.931709){
                                                                state=WALKING;
                                                            }
                                                        }
                                                    }
                                                    if(SumDifAccZ > 0.083135){
                                                        if(SumDifIncAng <= 93.261729){
                                                            state=STATIONARY;
                                                        }
                                                        if(SumDifIncAng > 93.261729){
                                                            state=TRANSITION;
                                                        }
                                                    }
                                                }
                                                if(SumDifIncAng > 94.164899){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumGloAccXY > 358.28719){
                                                state=WALKDN;
                                            }
                                        }
                                        if(SumDifAccZ > 3.930263){
                                            if(SumGloAccXY <= 222.691787){
                                                state=WALKING;
                                            }
                                            if(SumGloAccXY > 222.691787){
                                                if(SumGloAccXY <= 241.167482){
                                                    state=WALKDN;
                                                }
                                                if(SumGloAccXY > 241.167482){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                    }
                                    if(SumDifPre > -6.770891){
                                        if(SumDifIncAng <= 93.630727){
                                            if(SumGloGyrXY <= 95.827441){
                                                if(SumDifAccZ <= 8.135023){
                                                    state=WALKING;
                                                }
                                                if(SumDifAccZ > 8.135023){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(SumGloGyrXY > 95.827441){
                                                if(SumDifPre <= 12.134329){
                                                    if(SumDifIncAng <= 92.422166){
                                                        if(SumDifIncAng <= 91.782847){
                                                            if(SumDifPre <= 6.16819){
                                                                state=STATIONARY;
                                                            }
                                                            if(SumDifPre > 6.16819){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(SumDifIncAng > 91.782847){
                                                            state=WALKING;
                                                        }
                                                    }
                                                    if(SumDifIncAng > 92.422166){
                                                        state=WALKUP;
                                                    }
                                                }
                                                if(SumDifPre > 12.134329){
                                                    state=WALKUP;
                                                }
                                            }
                                        }
                                        if(SumDifIncAng > 93.630727){
                                            if(SumGloGyrXY <= 36.453616){
                                                if(SumDifAccZ <= -2.338172){
                                                    state=WALKING;
                                                }
                                                if(SumDifAccZ > -2.338172){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(SumGloGyrXY > 36.453616){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                                if(SumDifIncAng > 98.197353){
                                    if(SumGloGyrXY <= 33.583567){
                                        if(SumDifPre <= -1.190885){
                                            if(SumDifAccZ <= -6.348536){
                                                if(SumGloGyrXY <= 31.308643){
                                                    state=WALKING;
                                                }
                                                if(SumGloGyrXY > 31.308643){
                                                    state=WALKDN;
                                                }
                                            }
                                            if(SumDifAccZ > -6.348536){
                                                if(SumGloAccXY <= 174.094094){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloAccXY > 174.094094){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SumDifPre > -1.190885){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumGloGyrXY > 33.583567){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                        if(SumGloAccXY > 362.438004){
                            if(SumGloGyrXY <= 67.852113){
                                if(SumDifIncAng <= 99.367443){
                                    if(SumDifPre <= -6.467126){
                                        state=WALKING;
                                    }
                                    if(SumDifPre > -6.467126){
                                        if(SumGloGyrXY <= 52.958505){
                                            if(SumDifAccZ <= -22.752465){
                                                if(SumGloGyrXY <= 30.454486){
                                                    state=STATIONARY;
                                                }
                                                if(SumGloGyrXY > 30.454486){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumDifAccZ > -22.752465){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumGloGyrXY > 52.958505){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifIncAng > 99.367443){
                                    state=WALKING;
                                }
                            }
                            if(SumGloGyrXY > 67.852113){
                                if(SumDifIncAng <= 98.137767){
                                    if(SumDifPre <= 6.718556){
                                        if(SumDifPre <= -6.517115){
                                            if(SumGloAccXY <= 1813.842278){
                                                if(SumDifAccZ <= 9.323927){
                                                    if(SumDifPre <= -10.335695){
                                                        if(SumDifAccZ <= -0.695786){
                                                            if(SumGloAccXY <= 794.346152){
                                                                if(SumDifAccZ <= -11.531242){
                                                                    state=WALKDN;
                                                                }
                                                                if(SumDifAccZ > -11.531242){
                                                                    state=WALKING;
                                                                }
                                                            }
                                                            if(SumGloAccXY > 794.346152){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(SumDifAccZ > -0.695786){
                                                            state=WALKING;
                                                        }
                                                    }
                                                    if(SumDifPre > -10.335695){
                                                        state=WALKING;
                                                    }
                                                }
                                                if(SumDifAccZ > 9.323927){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SumGloAccXY > 1813.842278){
                                                state=WALKING;
                                            }
                                        }
                                        if(SumDifPre > -6.517115){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifPre > 6.718556){
                                        state=WALKING;
                                    }
                                }
                                if(SumDifIncAng > 98.137767){
                                    state=WALKING;
                                }
                            }
                        }
                    }
                    if(SumDifPre > 14.117962){
                        if(SumGloGyrXY <= 64.61461){
                            if(SumDifIncAng <= 93.085106){
                                state=WALKING;
                            }
                            if(SumDifIncAng > 93.085106){
                                if(SumGloAccXY <= 171.732303){
                                    state=STATIONARY;
                                }
                                if(SumGloAccXY > 171.732303){
                                    if(SumGloGyrXY <= 50.186735){
                                        if(SumDifAccZ <= -50.498902){
                                            state=STATIONARY;
                                        }
                                        if(SumDifAccZ > -50.498902){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumGloGyrXY > 50.186735){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                        if(SumGloGyrXY > 64.61461){
                            if(SumDifIncAng <= 99.155963){
                                if(SumDifPre <= 19.977614){
                                    if(SumDifAccZ <= 8.997066){
                                        state=WALKING;
                                    }
                                    if(SumDifAccZ > 8.997066){
                                        if(SumGloAccXY <= 1541.304419){
                                            state=WALKUP;
                                        }
                                        if(SumGloAccXY > 1541.304419){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifPre > 19.977614){
                                    state=WALKUP;
                                }
                            }
                            if(SumDifIncAng > 99.155963){
                                if(SumDifPre <= 29.00131){
                                    if(SumDifAccZ <= 6.416303){
                                        if(SumGloAccXY <= 460.134384){
                                            if(SumDifPre <= 18.021878){
                                                state=WALKING;
                                            }
                                            if(SumDifPre > 18.021878){
                                                state=WALKUP;
                                            }
                                        }
                                        if(SumGloAccXY > 460.134384){
                                            state=WALKING;
                                        }
                                    }
                                    if(SumDifAccZ > 6.416303){
                                        if(SumGloAccXY <= 1080.251758){
                                            state=WALKUP;
                                        }
                                        if(SumGloAccXY > 1080.251758){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SumDifPre > 29.00131){
                                    if(SumGloAccXY <= 1796.064618){
                                        state=WALKUP;
                                    }
                                    if(SumGloAccXY > 1796.064618){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return state;
    }


    /**
     * The original classifier
     * @param featVector
     * @return
     */
    protected int classify(double [] featVector){
        double GloLpfAccY       = featVector[0];
        double SqBandPassGyro   = featVector[1];
        double SqLowPassDiffAcc = featVector[2];
        double AxisAngle        = featVector[3];
        double DiffPress        = featVector[4];

        if(SqBandPassGyro <= 59.614168){
            if(AxisAngle <= 203.784302){
                if(DiffPress <= 0.482763){
                    if(DiffPress <= -0.528793){
                        if(DiffPress <= -1.735247){
                            state=STATIONARY;
//                            Log.d(TAG, "class 1: " + state);
                        }
                        if(DiffPress > -1.735247){
                            if(SqLowPassDiffAcc <= 0.010131){
                                if(GloLpfAccY <= 2390.23341){
                                    state=STATIONARY;
//                                    Log.d(TAG, "class 2: " + state);
                                }
                                if(GloLpfAccY > 2390.23341){
                                    state=STATIONARY;
//                                    Log.d(TAG, "class 3: " + state);
                                }
                            }
                            if(SqLowPassDiffAcc > 0.010131){
                                state=STATIONARY;
//                                Log.d(TAG, "class 4: " + state);
                            }
                        }
                    }
                    if(DiffPress > -0.528793){
                        if(SqLowPassDiffAcc <= 0.126284){
                            if(AxisAngle <= 149.360451){
                                if(SqBandPassGyro <= 24.855979){
                                    if(DiffPress <= 0.201911){
                                        if(GloLpfAccY <= 2426.129109){
                                            if(SqLowPassDiffAcc <= 0.000235){
                                                if(AxisAngle <= 75.047233){
                                                    if(AxisAngle <= 67.053691){
                                                        state=STATIONARY;
//                                                        Log.d(TAG, "class 5: " + state);
                                                    }
                                                    if(AxisAngle > 67.053691){
                                                        state=STATIONARY;

                                                    }
                                                }
                                                if(AxisAngle > 75.047233){
                                                    if(AxisAngle <= 132.647742){
                                                        state=STATIONARY;
//                                                        Log.d(TAG, "class 6: " + state);
                                                    }
                                                    if(AxisAngle > 132.647742){
                                                        if(GloLpfAccY <= 2401.182424){
                                                            state=STATIONARY;
//                                                            Log.d(TAG, "class 7: " + state);
                                                        }
                                                        if(GloLpfAccY > 2401.182424){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                }
                                            }
                                            if(SqLowPassDiffAcc > 0.000235){
                                                state=STATIONARY;
//                                                Log.d(TAG, "class 8: " + state);
                                            }
                                        }
                                        if(GloLpfAccY > 2426.129109){
                                            state=STATIONARY;
//                                            Log.d(TAG, "class 9: " + state);
                                        }
                                    }
                                    if(DiffPress > 0.201911){
                                        state=STATIONARY;
//                                        Log.d(TAG, "class 10: " + state);
                                    }
                                }
                                if(SqBandPassGyro > 24.855979){
                                    if(DiffPress <= -0.16003){
                                        if(SqLowPassDiffAcc <= 0.028849){
                                            state=STATIONARY;
//                                            Log.d(TAG, "class 11: " + state);

                                        }
                                        if(SqLowPassDiffAcc > 0.028849){
                                            state=WALKING; //WALKDN

                                        }
                                    }
                                    if(DiffPress > -0.16003){
                                        state=STATIONARY;
                                    }
                                }
                            }
                            if(AxisAngle > 149.360451){
                                if(SqBandPassGyro <= 0.031771){
                                    if(AxisAngle <= 190.839242){
                                        state=STATIONARY;
                                    }
                                    if(AxisAngle > 190.839242){
                                        state=STATIONARY;
                                    }
                                }
                                if(SqBandPassGyro > 0.031771){
                                    if(GloLpfAccY <= 2412.537235){
                                        if(SqBandPassGyro <= 37.050969){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 37.050969){
                                            if(SqLowPassDiffAcc <= 0.030217){
                                                if(AxisAngle <= 196.526295){
                                                    state=STATIONARY;
                                                }
                                                if(AxisAngle > 196.526295){
                                                    state=WALKING;
                                                }
                                            }
                                            if(SqLowPassDiffAcc > 0.030217){
                                                state=STATIONARY;
                                            }
                                        }
                                    }
                                    if(GloLpfAccY > 2412.537235){
                                        if(GloLpfAccY <= 2478.734362){
                                            if(GloLpfAccY <= 2461.357468){
                                                if(AxisAngle <= 194.797482){
                                                    state=STATIONARY;
                                                }
                                                if(AxisAngle > 194.797482){
                                                    if(GloLpfAccY <= 2425.273764){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2425.273764){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                            if(GloLpfAccY > 2461.357468){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(GloLpfAccY > 2478.734362){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                            }
                        }
                        if(SqLowPassDiffAcc > 0.126284){
                            if(AxisAngle <= 146.53592){
                                if(GloLpfAccY <= 2246.142746){
                                    state=TRANSITION;
                                }
                                if(GloLpfAccY > 2246.142746){
                                    state=STATIONARY;
                                }
                            }
                            if(AxisAngle > 146.53592){
                                state=TRANSITION;
                            }
                        }
                    }
                }
                if(DiffPress > 0.482763){
                    if(DiffPress <= 1.014368){
                        if(GloLpfAccY <= 2496.837121){
                            state=STATIONARY;
                        }
                        if(GloLpfAccY > 2496.837121){
                            state=STATIONARY;
                        }
                    }
                    if(DiffPress > 1.014368){
                        state=STATIONARY;
                    }
                }
            }
            if(AxisAngle > 203.784302){
                if(GloLpfAccY <= 2550.261655){
                    if(SqLowPassDiffAcc <= 0.056672){
                        if(SqLowPassDiffAcc <= 0.001768){
                            if(AxisAngle <= 329.965185){
                                if(GloLpfAccY <= 2520.433597){
                                    if(GloLpfAccY <= 2404.764373){
                                        if(SqLowPassDiffAcc <= 0.000279){
                                            if(AxisAngle <= 320.06711){
                                                if(GloLpfAccY <= 2372.437236){
                                                    state=STATIONARY;
                                                }
                                                if(GloLpfAccY > 2372.437236){
                                                    if(SqBandPassGyro <= 0.045573){
                                                        state=STATIONARY;
                                                    }
                                                    if(SqBandPassGyro > 0.045573){
                                                        if(AxisAngle <= 239.168988){
                                                            state=STATIONARY;
                                                        }
                                                        if(AxisAngle > 239.168988){
                                                            if(GloLpfAccY <= 2395.976382){
                                                                state=STATIONARY;
                                                            }
                                                            if(GloLpfAccY > 2395.976382){
                                                                if(AxisAngle <= 290.092891){
                                                                    state=STATIONARY;
                                                                }
                                                                if(AxisAngle > 290.092891){
                                                                    if(SqBandPassGyro <= 0.751739){
                                                                        state=STATIONARY;
                                                                    }
                                                                    if(SqBandPassGyro > 0.751739){
                                                                        state=STATIONARY;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if(AxisAngle > 320.06711){
                                                if(SqBandPassGyro <= 0.00454){
                                                    state=STATIONARY;
                                                }
                                                if(SqBandPassGyro > 0.00454){
                                                    if(AxisAngle <= 320.864419){
                                                        state=STATIONARY;
                                                    }
                                                    if(AxisAngle > 320.864419){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                        if(SqLowPassDiffAcc > 0.000279){
                                            if(SqBandPassGyro <= 1.147688){
                                                state=STATIONARY;
                                            }
                                            if(SqBandPassGyro > 1.147688){
                                                if(GloLpfAccY <= 2388.99056){
                                                    if(AxisAngle <= 225.41776){
                                                        state=STATIONARY;
                                                    }
                                                    if(AxisAngle > 225.41776){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(GloLpfAccY > 2388.99056){
                                                    if(GloLpfAccY <= 2401.727265){
                                                        if(AxisAngle <= 238.293289){
                                                            state=STATIONARY;
                                                        }
                                                        if(AxisAngle > 238.293289){
                                                            if(AxisAngle <= 303.869257){
                                                                state=STATIONARY;
                                                            }
                                                            if(AxisAngle > 303.869257){
                                                                if(GloLpfAccY <= 2395.891242){
                                                                    state=STATIONARY;
                                                                }
                                                                if(GloLpfAccY > 2395.891242){
                                                                    state=STATIONARY;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if(GloLpfAccY > 2401.727265){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if(GloLpfAccY > 2404.764373){
                                        if(GloLpfAccY <= 2455.456347){
                                            if(GloLpfAccY <= 2451.127563){
                                                if(AxisAngle <= 326.253607){
                                                    if(AxisAngle <= 217.661519){
                                                        if(GloLpfAccY <= 2436.501538){
                                                            state=STATIONARY;
                                                        }
                                                        if(GloLpfAccY > 2436.501538){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(AxisAngle > 217.661519){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(AxisAngle > 326.253607){
                                                    if(GloLpfAccY <= 2411.193716){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2411.193716){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                            if(GloLpfAccY > 2451.127563){
                                                if(AxisAngle <= 276.710342){
                                                    state=STATIONARY;
                                                }
                                                if(AxisAngle > 276.710342){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                        if(GloLpfAccY > 2455.456347){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                                if(GloLpfAccY > 2520.433597){
                                    if(AxisAngle <= 301.051448){
                                        state=STATIONARY;
                                    }
                                    if(AxisAngle > 301.051448){
                                        state=STATIONARY;
                                    }
                                }
                            }
                            if(AxisAngle > 329.965185){
                                if(AxisAngle <= 337.80225){
                                    if(GloLpfAccY <= 2401.629308){
                                        if(GloLpfAccY <= 2395.824549){
                                            if(SqBandPassGyro <= 0.011999){
                                                state=STATIONARY;
                                            }
                                            if(SqBandPassGyro > 0.011999){
                                                if(GloLpfAccY <= 2379.734385){
                                                    if(GloLpfAccY <= 2377.399596){
                                                        if(AxisAngle <= 335.067716){
                                                            state=STATIONARY;
                                                        }
                                                        if(AxisAngle > 335.067716){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(GloLpfAccY > 2377.399596){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(GloLpfAccY > 2379.734385){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                        if(GloLpfAccY > 2395.824549){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(GloLpfAccY > 2401.629308){
                                        if(GloLpfAccY <= 2435.674836){
                                            if(AxisAngle <= 336.605627){
                                                if(SqLowPassDiffAcc <= 0.000154){
                                                    state=STATIONARY;
                                                }
                                                if(SqLowPassDiffAcc > 0.000154){
                                                    if(GloLpfAccY <= 2411.876737){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2411.876737){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                            if(AxisAngle > 336.605627){
                                                if(GloLpfAccY <= 2411.215405){
                                                    state=STATIONARY;
                                                }
                                                if(GloLpfAccY > 2411.215405){
                                                    if(GloLpfAccY <= 2412.114583){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2412.114583){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                        if(GloLpfAccY > 2435.674836){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                                if(AxisAngle > 337.80225){
                                    if(AxisAngle <= 398.530324){
                                        if(GloLpfAccY <= 2428.280497){
                                            if(SqBandPassGyro <= 0.020183){
                                                if(SqBandPassGyro <= 0.002472){
                                                    state=STATIONARY;
                                                }
                                                if(SqBandPassGyro > 0.002472){
                                                    if(AxisAngle <= 360.188093){
                                                        if(DiffPress <= -0.073506){
                                                            state=STATIONARY;
                                                        }
                                                        if(DiffPress > -0.073506){
                                                            if(SqLowPassDiffAcc <= 0.000084){
                                                                if(AxisAngle <= 350.814216){
                                                                    if(GloLpfAccY <= 2411.708185){
                                                                        state=STATIONARY;
                                                                    }
                                                                    if(GloLpfAccY > 2411.708185){
                                                                        state=STATIONARY;
                                                                    }
                                                                }
                                                                if(AxisAngle > 350.814216){
                                                                    state=STATIONARY;
                                                                }
                                                            }
                                                            if(SqLowPassDiffAcc > 0.000084){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                    }
                                                    if(AxisAngle > 360.188093){
                                                        if(GloLpfAccY <= 2402.533708){
                                                            if(GloLpfAccY <= 2390.95422){
                                                                if(SqBandPassGyro <= 0.008026){
                                                                    state=STATIONARY;
                                                                }
                                                                if(SqBandPassGyro > 0.008026){
                                                                    state=STATIONARY;
                                                                }
                                                            }
                                                            if(GloLpfAccY > 2390.95422){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                        if(GloLpfAccY > 2402.533708){
                                                            if(AxisAngle <= 375.061801){
                                                                if(GloLpfAccY <= 2414.447041){
                                                                    state=STATIONARY;
                                                                }
                                                                if(GloLpfAccY > 2414.447041){
                                                                    state=STATIONARY;
                                                                }
                                                            }
                                                            if(AxisAngle > 375.061801){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if(SqBandPassGyro > 0.020183){
                                                if(AxisAngle <= 360.555393){
                                                    if(GloLpfAccY <= 2363.668889){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2363.668889){
                                                        if(AxisAngle <= 354.948077){
                                                            if(SqBandPassGyro <= 1.931349){
                                                                if(AxisAngle <= 341.390071){
                                                                    if(GloLpfAccY <= 2377.568327){
                                                                        if(SqBandPassGyro <= 0.107121){
                                                                            if(GloLpfAccY <= 2375.631266){
                                                                                state=STATIONARY;
                                                                            }
                                                                            if(GloLpfAccY > 2375.631266){
                                                                                state=STATIONARY;
                                                                            }
                                                                        }
                                                                        if(SqBandPassGyro > 0.107121){
                                                                            state=STATIONARY;
                                                                        }
                                                                    }
                                                                    if(GloLpfAccY > 2377.568327){
                                                                        state=STATIONARY;
                                                                    }
                                                                }
                                                                if(AxisAngle > 341.390071){
                                                                    state=STATIONARY;
                                                                }
                                                            }
                                                            if(SqBandPassGyro > 1.931349){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                        if(AxisAngle > 354.948077){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                }
                                                if(AxisAngle > 360.555393){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                        if(GloLpfAccY > 2428.280497){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(AxisAngle > 398.530324){
                                        if(GloLpfAccY <= 2387.930485){
                                            if(GloLpfAccY <= 2375.062424){
                                                if(GloLpfAccY <= 2365.795497){
                                                    state=STATIONARY;
                                                }
                                                if(GloLpfAccY > 2365.795497){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(GloLpfAccY > 2375.062424){
                                                if(AxisAngle <= 413.624282){
                                                    if(GloLpfAccY <= 2380.132245){
                                                        if(AxisAngle <= 408.556375){
                                                            if(AxisAngle <= 401.353942){
                                                                state=STATIONARY;
                                                            }
                                                            if(AxisAngle > 401.353942){
                                                                if(GloLpfAccY <= 2376.876281){
                                                                    state=STATIONARY;
                                                                }
                                                                if(GloLpfAccY > 2376.876281){
                                                                    if(DiffPress <= -0.022867){
                                                                        state=STATIONARY;
                                                                    }
                                                                    if(DiffPress > -0.022867){
                                                                        state=STATIONARY;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if(AxisAngle > 408.556375){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(GloLpfAccY > 2380.132245){
                                                        if(AxisAngle <= 404.506096){
                                                            if(AxisAngle <= 400.956397){
                                                                state=STATIONARY;
                                                            }
                                                            if(AxisAngle > 400.956397){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                        if(AxisAngle > 404.506096){
                                                            if(AxisAngle <= 410.099419){
                                                                state=STATIONARY;
                                                            }
                                                            if(AxisAngle > 410.099419){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                    }
                                                }
                                                if(AxisAngle > 413.624282){
                                                    if(AxisAngle <= 495.068222){
                                                        if(SqLowPassDiffAcc <= 0.000241){
                                                            state=STATIONARY;
                                                        }
                                                        if(SqLowPassDiffAcc > 0.000241){
                                                            if(AxisAngle <= 457.772885){
                                                                state=STATIONARY;
                                                            }
                                                            if(AxisAngle > 457.772885){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                    }
                                                    if(AxisAngle > 495.068222){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                        if(GloLpfAccY > 2387.930485){
                                            if(GloLpfAccY <= 2484.164481){
                                                if(AxisAngle <= 538.053052){
                                                    if(AxisAngle <= 425.120929){
                                                        if(AxisAngle <= 403.64345){
                                                            if(SqLowPassDiffAcc <= 0.000057){
                                                                state=STATIONARY;
                                                            }
                                                            if(SqLowPassDiffAcc > 0.000057){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                        if(AxisAngle > 403.64345){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(AxisAngle > 425.120929){
                                                        if(AxisAngle <= 430.309301){
                                                            state=STATIONARY;
                                                        }
                                                        if(AxisAngle > 430.309301){
                                                            if(GloLpfAccY <= 2416.810861){
                                                                if(GloLpfAccY <= 2399.408322){
                                                                    if(AxisAngle <= 445.431728){
                                                                        state=STATIONARY;
                                                                    }
                                                                    if(AxisAngle > 445.431728){
                                                                        if(SqBandPassGyro <= 0.006341){
                                                                            state=STATIONARY;
                                                                        }
                                                                        if(SqBandPassGyro > 0.006341){
                                                                            if(AxisAngle <= 449.80892){
                                                                                state=STATIONARY;
                                                                            }
                                                                            if(AxisAngle > 449.80892){
                                                                                if(SqLowPassDiffAcc <= 0.000139){
                                                                                    if(SqBandPassGyro <= 0.014268){
                                                                                        if(SqBandPassGyro <= 0.007061){
                                                                                            state=STATIONARY;
                                                                                        }
                                                                                        if(SqBandPassGyro > 0.007061){
                                                                                            state=STATIONARY;
                                                                                        }
                                                                                    }
                                                                                    if(SqBandPassGyro > 0.014268){
                                                                                        state=STATIONARY;
                                                                                    }
                                                                                }
                                                                                if(SqLowPassDiffAcc > 0.000139){
                                                                                    state=STATIONARY;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                if(GloLpfAccY > 2399.408322){
                                                                    if(AxisAngle <= 465.892624){
                                                                        if(DiffPress <= -0.022304){
                                                                            state=STATIONARY;
                                                                        }
                                                                        if(DiffPress > -0.022304){
                                                                            if(AxisAngle <= 445.745274){
                                                                                if(AxisAngle <= 434.133941){
                                                                                    state=STATIONARY;
                                                                                }
                                                                                if(AxisAngle > 434.133941){
                                                                                    state=STATIONARY;
                                                                                }
                                                                            }
                                                                            if(AxisAngle > 445.745274){
                                                                                state=STATIONARY;
                                                                            }
                                                                        }
                                                                    }
                                                                    if(AxisAngle > 465.892624){
                                                                        state=STATIONARY;
                                                                    }
                                                                }
                                                            }
                                                            if(GloLpfAccY > 2416.810861){
                                                                if(AxisAngle <= 533.478165){
                                                                    state=STATIONARY;
                                                                }
                                                                if(AxisAngle > 533.478165){
                                                                    if(GloLpfAccY <= 2438.61449){
                                                                        state=STATIONARY;
                                                                    }
                                                                    if(GloLpfAccY > 2438.61449){
                                                                        state=STATIONARY;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if(AxisAngle > 538.053052){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(GloLpfAccY > 2484.164481){
                                                if(GloLpfAccY <= 2493.274885){
                                                    if(SqBandPassGyro <= 0.039491){
                                                        state=STATIONARY;
                                                    }
                                                    if(SqBandPassGyro > 0.039491){
                                                        if(AxisAngle <= 448.502341){
                                                            state=STATIONARY;
                                                        }
                                                        if(AxisAngle > 448.502341){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                }
                                                if(GloLpfAccY > 2493.274885){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(SqLowPassDiffAcc > 0.001768){
                            if(DiffPress <= 0.436813){
                                if(DiffPress <= -0.586156){
                                    state=STATIONARY;
                                }
                                if(DiffPress > -0.586156){
                                    if(AxisAngle <= 306.897019){
                                        if(GloLpfAccY <= 2401.426658){
                                            if(AxisAngle <= 219.004749){
                                                state=STATIONARY;
                                            }
                                            if(AxisAngle > 219.004749){
                                                if(SqBandPassGyro <= 3.457059){
                                                    state=STATIONARY;
                                                }
                                                if(SqBandPassGyro > 3.457059){
                                                    if(GloLpfAccY <= 2387.930485){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2387.930485){
                                                        if(SqLowPassDiffAcc <= 0.004219){
                                                            state=STATIONARY;
                                                        }
                                                        if(SqLowPassDiffAcc > 0.004219){
                                                            if(AxisAngle <= 296.128382){
                                                                if(DiffPress <= -0.100831){
                                                                    state=STATIONARY;
                                                                }
                                                                if(DiffPress > -0.100831){
                                                                    state=STATIONARY;
                                                                }
                                                            }
                                                            if(AxisAngle > 296.128382){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if(GloLpfAccY > 2401.426658){
                                            if(SqBandPassGyro <= 0.357067){
                                                state=STATIONARY;
                                            }
                                            if(SqBandPassGyro > 0.357067){
                                                if(GloLpfAccY <= 2439.170426){
                                                    state=STATIONARY;
                                                }
                                                if(GloLpfAccY > 2439.170426){
                                                    if(GloLpfAccY <= 2519.821632){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2519.821632){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if(AxisAngle > 306.897019){
                                        if(SqBandPassGyro <= 16.90092){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 16.90092){
                                            if(AxisAngle <= 413.388846){
                                                if(GloLpfAccY <= 2386.952776){
                                                    if(SqLowPassDiffAcc <= 0.013584){
                                                        state=STATIONARY;
                                                    }
                                                    if(SqLowPassDiffAcc > 0.013584){
                                                        if(AxisAngle <= 390.404902){
                                                            state=STATIONARY;
                                                        }
                                                        if(AxisAngle > 390.404902){
                                                            if(GloLpfAccY <= 2372.276769){
                                                                state=STATIONARY;
                                                            }
                                                            if(GloLpfAccY > 2372.276769){
                                                                state=STATIONARY;
                                                            }
                                                        }
                                                    }
                                                }
                                                if(GloLpfAccY > 2386.952776){
                                                    state=STATIONARY;
                                                }
                                            }
                                            if(AxisAngle > 413.388846){
                                                if(GloLpfAccY <= 2382.703156){
                                                    state=STATIONARY;
                                                }
                                                if(GloLpfAccY > 2382.703156){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(DiffPress > 0.436813){
                                if(SqLowPassDiffAcc <= 0.012567){
                                    state=STATIONARY;
                                }
                                if(SqLowPassDiffAcc > 0.012567){
                                    state=STATIONARY;
                                }
                            }
                        }
                    }
                    if(SqLowPassDiffAcc > 0.056672){
                        if(SqLowPassDiffAcc <= 0.264825){
                            if(GloLpfAccY <= 2503.746228){
                                if(AxisAngle <= 215.298269){
                                    state=STATIONARY;
                                }
                                if(AxisAngle > 215.298269){
                                    if(AxisAngle <= 407.467732){
                                        if(SqBandPassGyro <= 16.11775){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 16.11775){
                                            if(GloLpfAccY <= 2399.911591){
                                                if(GloLpfAccY <= 2346.093617){
                                                    state=STATIONARY;
                                                }
                                                if(GloLpfAccY > 2346.093617){
                                                    if(SqBandPassGyro <= 33.515397){
                                                        state=STATIONARY;
                                                    }
                                                    if(SqBandPassGyro > 33.515397){
                                                        if(SqLowPassDiffAcc <= 0.097681){
                                                            state=STATIONARY;
                                                        }
                                                        if(SqLowPassDiffAcc > 0.097681){
                                                            state=TRANSITION;
                                                        }
                                                    }
                                                }
                                            }
                                            if(GloLpfAccY > 2399.911591){
                                                state=STATIONARY;
                                            }
                                        }
                                    }
                                    if(AxisAngle > 407.467732){
                                        if(SqBandPassGyro <= 31.437015){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 31.437015){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                            }
                            if(GloLpfAccY > 2503.746228){
                                if(DiffPress <= 0.081939){
                                    state=STATIONARY;
                                }
                                if(DiffPress > 0.081939){
                                    state=STATIONARY; //WALKUP
                                }
                            }
                        }
                        if(SqLowPassDiffAcc > 0.264825){
                            if(GloLpfAccY <= 2210.627644){
                                state=TRANSITION;
                            }
                            if(GloLpfAccY > 2210.627644){
                                if(AxisAngle <= 246.3809){
                                    if(AxisAngle <= 208.496017){
                                        if(GloLpfAccY <= 2244.055351){
                                            state=STATIONARY;
                                        }
                                        if(GloLpfAccY > 2244.055351){
                                            state=TRANSITION;
                                        }
                                    }
                                    if(AxisAngle > 208.496017){
                                        if(SqBandPassGyro <= 21.806881){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 21.806881){
                                            state=TRANSITION;
                                        }
                                    }
                                }
                                if(AxisAngle > 246.3809){
                                    state=TRANSITION;
                                }
                            }
                        }
                    }
                }
                if(GloLpfAccY > 2550.261655){
                    if(SqBandPassGyro <= 9.442254){
                        if(GloLpfAccY <= 2614.484567){
                            if(AxisAngle <= 391.636699){
                                if(DiffPress <= 0.838618){
                                    if(AxisAngle <= 250.456213){
                                        state=STATIONARY;
                                    }
                                    if(AxisAngle > 250.456213){
                                        if(GloLpfAccY <= 2589.912338){
                                            if(DiffPress <= -0.121811){
                                                state=STATIONARY;
                                            }
                                            if(DiffPress > -0.121811){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(GloLpfAccY > 2589.912338){
                                            if(SqLowPassDiffAcc <= 0.002207){
                                                state=STATIONARY;
                                            }
                                            if(SqLowPassDiffAcc > 0.002207){
                                                if(SqBandPassGyro <= 3.117815){
                                                    if(SqLowPassDiffAcc <= 0.005596){
                                                        state=STATIONARY;
                                                    }
                                                    if(SqLowPassDiffAcc > 0.005596){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(SqBandPassGyro > 3.117815){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                    }
                                }
                                if(DiffPress > 0.838618){
                                    state=STATIONARY;
                                }
                            }
                            if(AxisAngle > 391.636699){
                                if(AxisAngle <= 493.521164){
                                    state=STATIONARY;
                                }
                                if(AxisAngle > 493.521164){
                                    if(GloLpfAccY <= 2586.211679){
                                        state=STATIONARY;
                                    }
                                    if(GloLpfAccY > 2586.211679){
                                        state=STATIONARY;
                                    }
                                }
                            }
                        }
                        if(GloLpfAccY > 2614.484567){
                            if(DiffPress <= 0.379793){
                                if(DiffPress <= -2.381754){
                                    state=STATIONARY;
                                }
                                if(DiffPress > -2.381754){
                                    if(SqLowPassDiffAcc <= 0.006901){
                                        state=STATIONARY;
                                    }
                                    if(SqLowPassDiffAcc > 0.006901){
                                        if(SqBandPassGyro <= 2.96246){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 2.96246){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                            }
                            if(DiffPress > 0.379793){
                                state=STATIONARY;
                            }
                        }
                    }
                    if(SqBandPassGyro > 9.442254){
                        if(GloLpfAccY <= 2598.450823){
                            if(AxisAngle <= 276.297019){
                                state=STATIONARY;
                            }
                            if(AxisAngle > 276.297019){
                                if(AxisAngle <= 468.102221){
                                    state=STATIONARY;
                                }
                                if(AxisAngle > 468.102221){
                                    if(GloLpfAccY <= 2569.94748){
                                        state=STATIONARY;
                                    }
                                    if(GloLpfAccY > 2569.94748){
                                        if(SqBandPassGyro <= 29.201439){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 29.201439){
                                            state=WALKING;
                                        }
                                    }
                                }
                            }
                        }
                        if(GloLpfAccY > 2598.450823){
                            state=STATIONARY;
                        }
                    }
                }
            }
        }
        if(SqBandPassGyro > 59.614168){
            if(SqLowPassDiffAcc <= 0.046173){
                if(DiffPress <= -0.236495){
                    if(DiffPress <= -0.365926){
                        if(SqLowPassDiffAcc <= 0.000816){
                            state=WALKING;
                        }
                        if(SqLowPassDiffAcc > 0.000816){
                            if(SqBandPassGyro <= 150.42684){
                                if(AxisAngle <= 40.802945){
                                    state=STATIONARY;
                                }
                                if(AxisAngle > 40.802945){
                                    state=WALKING;
                                }
                            }
                            if(SqBandPassGyro > 150.42684){
                                if(SqLowPassDiffAcc <= 0.010916){
                                    if(DiffPress <= -0.443955){
                                        state=WALKDN;
                                    }
                                    if(DiffPress > -0.443955){
                                        if(SqLowPassDiffAcc <= 0.001182){
                                            state=WALKING;
                                        }
                                        if(SqLowPassDiffAcc > 0.001182){
                                            state=WALKING; //WALKDN
                                        }
                                    }
                                }
                                if(SqLowPassDiffAcc > 0.010916){
                                    state=WALKING; //WALKDN
                                }
                            }
                        }
                    }
                    if(DiffPress > -0.365926){
                        if(SqLowPassDiffAcc <= 0.003753){
                            if(SqBandPassGyro <= 1069.231572){
                                state=WALKING;
                            }
                            if(SqBandPassGyro > 1069.231572){
                                if(AxisAngle <= 37.260919){
                                    state=WALKING; //WALKDN
                                }
                                if(AxisAngle > 37.260919){
                                    state=WALKING;
                                }
                            }
                        }
                        if(SqLowPassDiffAcc > 0.003753){
                            if(SqBandPassGyro <= 108.493264){
                                if(GloLpfAccY <= 2445.70746){
                                    if(GloLpfAccY <= 2409.43754){
                                        state=STATIONARY;
                                    }
                                    if(GloLpfAccY > 2409.43754){
                                        state=WALKING;
                                    }
                                }
                                if(GloLpfAccY > 2445.70746){
                                    state=STATIONARY;
                                }
                            }
                            if(SqBandPassGyro > 108.493264){
                                if(SqBandPassGyro <= 323.709759){
                                    if(AxisAngle <= 45.861367){
                                        state=WALKING;
                                    }
                                    if(AxisAngle > 45.861367){
                                        if(DiffPress <= -0.278119){
                                            state=WALKDN;
                                        }
                                        if(DiffPress > -0.278119){
                                            state=WALKING;
                                        }
                                    }
                                }
                                if(SqBandPassGyro > 323.709759){
                                    state=WALKING;
                                }
                            }
                        }
                    }
                }
                if(DiffPress > -0.236495){
                    if(DiffPress <= 0.248841){
                        if(SqBandPassGyro <= 189.68767){
                            if(AxisAngle <= 242.469077){
                                if(SqLowPassDiffAcc <= 0.002581){
                                    if(GloLpfAccY <= 2455.895326){
                                        state=WALKING;
                                    }
                                    if(GloLpfAccY > 2455.895326){
                                        if(SqBandPassGyro <= 112.543364){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 112.543364){
                                            if(AxisAngle <= 48.76706){
                                                if(SqLowPassDiffAcc <= 0.001887){
                                                    state=STATIONARY;
                                                }
                                                if(SqLowPassDiffAcc > 0.001887){
                                                    if(GloLpfAccY <= 2460.9822){
                                                        state=STATIONARY;
                                                    }
                                                    if(GloLpfAccY > 2460.9822){
                                                        state=WALKING;
                                                    }
                                                }
                                            }
                                            if(AxisAngle > 48.76706){
                                                state=WALKING;
                                            }
                                        }
                                    }
                                }
                                if(SqLowPassDiffAcc > 0.002581){
                                    if(SqBandPassGyro <= 94.917844){
                                        if(SqLowPassDiffAcc <= 0.014978){
                                            if(GloLpfAccY <= 2441.800498){
                                                state=WALKING;
                                            }
                                            if(GloLpfAccY > 2441.800498){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SqLowPassDiffAcc > 0.014978){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SqBandPassGyro > 94.917844){
                                        if(DiffPress <= -0.117161){
                                            state=WALKING;
                                        }
                                        if(DiffPress > -0.117161){
                                            if(GloLpfAccY <= 2433.898343){
                                                state=WALKING;
                                            }
                                            if(GloLpfAccY > 2433.898343){
                                                if(SqBandPassGyro <= 100.640139){
                                                    state=STATIONARY;
                                                }
                                                if(SqBandPassGyro > 100.640139){
                                                    if(SqLowPassDiffAcc <= 0.007421){
                                                        if(SqLowPassDiffAcc <= 0.006667){
                                                            if(AxisAngle <= 25.976813){
                                                                if(GloLpfAccY <= 2448.399205){
                                                                    state=WALKING;
                                                                }
                                                                if(GloLpfAccY > 2448.399205){
                                                                    state=STATIONARY;
                                                                }
                                                            }
                                                            if(AxisAngle > 25.976813){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(SqLowPassDiffAcc > 0.006667){
                                                            state=WALKING;
                                                        }
                                                    }
                                                    if(SqLowPassDiffAcc > 0.007421){
                                                        if(SqBandPassGyro <= 102.960787){
                                                            state=WALKING;
                                                        }
                                                        if(SqBandPassGyro > 102.960787){
                                                            if(DiffPress <= -0.029463){
                                                                state=WALKING;
                                                            }
                                                            if(DiffPress > -0.029463){
                                                                if(SqBandPassGyro <= 121.075679){
                                                                    state=STATIONARY;
                                                                }
                                                                if(SqBandPassGyro > 121.075679){
                                                                    state=WALKING;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(AxisAngle > 242.469077){
                                if(GloLpfAccY <= 2537.61707){
                                    if(GloLpfAccY <= 2403.265993){
                                        if(AxisAngle <= 405.921798){
                                            if(GloLpfAccY <= 2379.721994){
                                                state=STATIONARY;
                                            }
                                            if(GloLpfAccY > 2379.721994){
                                                if(SqLowPassDiffAcc <= 0.018725){
                                                    if(AxisAngle <= 269.739646){
                                                        state=WALKING;
                                                    }
                                                    if(AxisAngle > 269.739646){
                                                        if(GloLpfAccY <= 2388.761415){
                                                            if(SqBandPassGyro <= 147.647203){
                                                                state=STATIONARY;
                                                            }
                                                            if(SqBandPassGyro > 147.647203){
                                                                state=WALKING;
                                                            }
                                                        }
                                                        if(GloLpfAccY > 2388.761415){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                }
                                                if(SqLowPassDiffAcc > 0.018725){
                                                    state=STATIONARY;
                                                }
                                            }
                                        }
                                        if(AxisAngle > 405.921798){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(GloLpfAccY > 2403.265993){
                                        if(AxisAngle <= 269.862586){
                                            state=STATIONARY;
                                        }
                                        if(AxisAngle > 269.862586){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                                if(GloLpfAccY > 2537.61707){
                                    if(SqLowPassDiffAcc <= 0.004547){
                                        state=WALKING;
                                    }
                                    if(SqLowPassDiffAcc > 0.004547){
                                        if(GloLpfAccY <= 2609.476083){
                                            if(SqLowPassDiffAcc <= 0.010642){
                                                state=WALKING;
                                            }
                                            if(SqLowPassDiffAcc > 0.010642){
                                                if(DiffPress <= 0.09186){
                                                    state=WALKING;
                                                }
                                                if(DiffPress > 0.09186){
                                                    if(GloLpfAccY <= 2582.262346){
                                                        state=WALKING;
                                                    }
                                                    if(GloLpfAccY > 2582.262346){
                                                        state=STATIONARY;
                                                    }
                                                }
                                            }
                                        }
                                        if(GloLpfAccY > 2609.476083){
                                            state=STATIONARY;
                                        }
                                    }
                                }
                            }
                        }
                        if(SqBandPassGyro > 189.68767){
                            if(SqLowPassDiffAcc <= 0.003657){
                                if(DiffPress <= -0.186636){
                                    if(SqBandPassGyro <= 1652.56372){
                                        state=WALKING;
                                    }
                                    if(SqBandPassGyro > 1652.56372){
                                        state=WALKING; //WALKDN
                                    }
                                }
                                if(DiffPress > -0.186636){
                                    state=WALKING;
                                }
                            }
                            if(SqLowPassDiffAcc > 0.003657){
                                if(DiffPress <= -0.118695){
                                    state=WALKING;
                                }
                                if(DiffPress > -0.118695){
                                    if(DiffPress <= 0.136336){
                                        if(SqBandPassGyro <= 447.145036){
                                            if(AxisAngle <= 328.228486){
                                                state=WALKING;
                                            }
                                            if(AxisAngle > 328.228486){
                                                if(GloLpfAccY <= 2498.020643){
                                                    if(GloLpfAccY <= 2420.721574){
                                                        if(GloLpfAccY <= 2354.781696){
                                                            state=STATIONARY;
                                                        }
                                                        if(GloLpfAccY > 2354.781696){
                                                            state=WALKING;
                                                        }
                                                    }
                                                    if(GloLpfAccY > 2420.721574){
                                                        state=STATIONARY;
                                                    }
                                                }
                                                if(GloLpfAccY > 2498.020643){
                                                    state=WALKING;
                                                }
                                            }
                                        }
                                        if(SqBandPassGyro > 447.145036){
                                            state=WALKING;
                                        }
                                    }
                                    if(DiffPress > 0.136336){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                    }
                    if(DiffPress > 0.248841){
                        if(SqLowPassDiffAcc <= 0.002144){
                            state=WALKING;
                        }
                        if(SqLowPassDiffAcc > 0.002144){
                            if(SqBandPassGyro <= 245.876037){
                                if(DiffPress <= 0.724458){
                                    if(GloLpfAccY <= 2395.644707){
                                        state=WALKING; //WALKUP
                                    }
                                    if(GloLpfAccY > 2395.644707){
                                        if(SqLowPassDiffAcc <= 0.03416){
                                            state=WALKING;
                                        }
                                        if(SqLowPassDiffAcc > 0.03416){
                                            state=WALKING; //WALKUP
                                        }
                                    }
                                }
                                if(DiffPress > 0.724458){
                                    state=STATIONARY;
                                }
                            }
                            if(SqBandPassGyro > 245.876037){
                                if(DiffPress <= 0.400492){
                                    if(GloLpfAccY <= 2420.695412){
                                        state=WALKING; //WALKUP
                                    }
                                    if(GloLpfAccY > 2420.695412){
                                        state=WALKING;
                                    }
                                }
                                if(DiffPress > 0.400492){
                                    state=WALKUP;
                                }
                            }
                        }
                    }
                }
            }
            if(SqLowPassDiffAcc > 0.046173){
                if(AxisAngle <= 160.761584){
                    if(DiffPress <= 0.172562){
                        if(SqLowPassDiffAcc <= 0.239356){
                            if(DiffPress <= -0.126424){
                                if(GloLpfAccY <= 2376.924142){
                                    if(SqLowPassDiffAcc <= 0.154402){
                                        state=WALKING; //WALKDN
                                    }
                                    if(SqLowPassDiffAcc > 0.154402){
                                        state=WALKING;
                                    }
                                }
                                if(GloLpfAccY > 2376.924142){
                                    if(SqBandPassGyro <= 167.47121){
                                        state=STATIONARY;
                                    }
                                    if(SqBandPassGyro > 167.47121){
                                        state=WALKING;
                                    }
                                }
                            }
                            if(DiffPress > -0.126424){
                                state=WALKING;
                            }
                        }
                        if(SqLowPassDiffAcc > 0.239356){
                            state=TRANSITION;
                        }
                    }
                    if(DiffPress > 0.172562){
                        if(SqLowPassDiffAcc <= 0.291681){
                            if(SqBandPassGyro <= 88.250302){
                                state=STATIONARY;
                            }
                            if(SqBandPassGyro > 88.250302){
                                if(SqLowPassDiffAcc <= 0.223062){
                                    if(AxisAngle <= 49.120798){
                                        state=WALKING;
                                    }
                                    if(AxisAngle > 49.120798){
                                        if(DiffPress <= 0.232581){
                                            if(GloLpfAccY <= 2353.591851){
                                                state=WALKING; //WALKUP
                                            }
                                            if(GloLpfAccY > 2353.591851){
                                                state=WALKING;
                                            }
                                        }
                                        if(DiffPress > 0.232581){
                                            state=WALKUP;
                                        }
                                    }
                                }
                                if(SqLowPassDiffAcc > 0.223062){
                                    state=WALKING; //WALKUP
                                }
                            }
                        }
                        if(SqLowPassDiffAcc > 0.291681){
                            state=TRANSITION;
                        }
                    }
                }
                if(AxisAngle > 160.761584){
                    if(GloLpfAccY <= 2477.254091){
                        if(SqLowPassDiffAcc <= 0.428981){
                            if(AxisAngle <= 323.333714){
                                if(DiffPress <= 0.388327){
                                    if(SqLowPassDiffAcc <= 0.089904){
                                        if(SqBandPassGyro <= 87.189124){
                                            state=STATIONARY;
                                        }
                                        if(SqBandPassGyro > 87.189124){
                                            state=WALKING;
                                        }
                                    }
                                    if(SqLowPassDiffAcc > 0.089904){
                                        if(SqBandPassGyro <= 167.409076){
                                            state=TRANSITION;
                                        }
                                        if(SqBandPassGyro > 167.409076){
                                            if(AxisAngle <= 244.974524){
                                                if(SqBandPassGyro <= 262.192796){
                                                    state=STATIONARY;
                                                }
                                                if(SqBandPassGyro > 262.192796){
                                                    state=WALKING;
                                                }
                                            }
                                            if(AxisAngle > 244.974524){
                                                state=TRANSITION;
                                            }
                                        }
                                    }
                                }
                                if(DiffPress > 0.388327){
                                    state=WALKUP;
                                }
                            }
                            if(AxisAngle > 323.333714){
                                if(SqBandPassGyro <= 216.798317){
                                    if(GloLpfAccY <= 2319.72179){
                                        state=TRANSITION;
                                    }
                                    if(GloLpfAccY > 2319.72179){
                                        if(SqLowPassDiffAcc <= 0.105653){
                                            if(AxisAngle <= 507.693641){
                                                if(SqLowPassDiffAcc <= 0.05014){
                                                    state=STATIONARY;
                                                }
                                                if(SqLowPassDiffAcc > 0.05014){
                                                    if(DiffPress <= -0.091415){
                                                        if(SqBandPassGyro <= 70.271791){
                                                            state=STATIONARY;
                                                        }
                                                        if(SqBandPassGyro > 70.271791){
                                                            state=STATIONARY;
                                                        }
                                                    }
                                                    if(DiffPress > -0.091415){
                                                        state=TRANSITION;
                                                    }
                                                }
                                            }
                                            if(AxisAngle > 507.693641){
                                                state=STATIONARY;
                                            }
                                        }
                                        if(SqLowPassDiffAcc > 0.105653){
                                            state=TRANSITION;
                                        }
                                    }
                                }
                                if(SqBandPassGyro > 216.798317){
                                    if(SqLowPassDiffAcc <= 0.396504){
                                        if(SqBandPassGyro <= 795.459959){
                                            state=TRANSITION;
                                        }
                                        if(SqBandPassGyro > 795.459959){
                                            state=STATIONARY;
                                        }
                                    }
                                    if(SqLowPassDiffAcc > 0.396504){
                                        state=WALKING;
                                    }
                                }
                            }
                        }
                        if(SqLowPassDiffAcc > 0.428981){
                            if(SqBandPassGyro <= 350.789703){
                                state=TRANSITION;
                            }
                            if(SqBandPassGyro > 350.789703){
                                if(SqLowPassDiffAcc <= 0.693762){
                                    state=WALKING;
                                }
                                if(SqLowPassDiffAcc > 0.693762){
                                    state=TRANSITION;
                                }
                            }
                        }
                    }
                    if(GloLpfAccY > 2477.254091){
                        if(DiffPress <= 0.260949){
                            if(SqBandPassGyro <= 68.455223){
                                state=STATIONARY;
                            }
                            if(SqBandPassGyro > 68.455223){
                                state=WALKING;
                            }
                        }
                        if(DiffPress > 0.260949){
                            state=WALKUP;
                        }
                    }
                }
            }
        }
        return state;
    }

}
