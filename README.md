# DarkForest

这是一个幻影围棋计算机博弈程序，一个可以和人类下棋的程序。

幻影围棋介绍：

幻影围棋是一项欧洲的棋类游戏，因为下棋规则是基于围棋，但又是在围棋的基础上加入了信息不完全的限制——看不到对方的落子，故名幻影围棋。

棋盘：9×9围棋的棋盘。

棋子：黑白两种围棋棋子。

实际上有3个棋盘，黑方棋盘，白方棋盘，裁判棋盘。

本方只清楚自己的落子情况，对于对方落子情况只能判断和猜测。裁判的棋盘才给出真正的棋局。

棋规：

黑白双方轮流落子，落子的基本规则与围棋一致，其中气、禁招等概念都相同；

幻影围棋中加入了信息隐藏的概念——在下棋时，双方都无法看到对手棋盘上的落子，形成两个不完备信息的棋盘，完备信息的对弈棋盘是由双方的棋盘取并集而成；

由于信息隐藏，就需要一个中间裁判。裁判可以看到双方棋盘，也就是说，从裁判角度所看到的是一个完备信息的9×9围棋棋盘，并且根据围棋规则判断双方落子是否合法，如果合法的话返回legal，若不合法则返回illegal；

当有一方落子后出现提子情况时，裁判会向双方返回提子数目与位置信息，双方同时更改棋面；

当一方所有落子都返回illegal时即可判断该方PASS；

直至双方都无法再落子，即双方都返回PASS，此时由裁判根据所占地域多少判定胜负。