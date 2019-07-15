#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jun 12 10:42:04 2018

@author: jumdar
"""
"""
    Input:dict
        example: data = {'a':1,'b':0}
    output:string,the result of run
"""
def BayesianModel(data):
    from pgmpy.models import BayesianModel
    from pgmpy.factors.discrete import TabularCPD
    import pandas as pd
    import numpy as np
    
    # 通过边来定义贝叶斯模型
    """
    x1:空气滤清器
    x2:空气流量计
    x3:节气门连接件
    x4:油泵电路
    x5:喷油器
    x6:燃油压力调节器
    y1:进气系统
    y2:燃油系统
    o1:发动机
    """
    model = BayesianModel([('x1', 'y1'), ('x2', 'y1'), ('x3', 'y1'), 
                           ('x4', 'y2'),('x5', 'y2'),('x6', 'y2'),
                           ('y1', 'o1'),('y2', 'o1')])
    
    # 定义条件概率分布
    cpd_x1 = TabularCPD(variable='x1', variable_card=2, values=[[0.05, 0.95]])
    cpd_x2 = TabularCPD(variable='x2', variable_card=2, values=[[0.05, 0.95]])
    cpd_x3 = TabularCPD(variable='x3', variable_card=2, values=[[0.05, 0.95]])
    cpd_x4 = TabularCPD(variable='x4', variable_card=2, values=[[0.1, 0.9]])
    cpd_x5 = TabularCPD(variable='x5', variable_card=2, values=[[0.075, 0.925]])
    cpd_x6 = TabularCPD(variable='x6', variable_card=2, values=[[0.005, 0.995]])
    
    
    # variable：变量
    # variable_card：基数
    # values：变量值
    # evidence：
    cpd_y1 = TabularCPD(variable='y1', variable_card=2, 
                       values=[[0.06,0.2,0.15,0.18,0.32,0.34,0.43,0.62],
                               [0.94,0.8,0.85,0.82,0.68,0.66,0.57,0.38]],
                      evidence=['x1', 'x2','x3'],
                      evidence_card=[2,2,2])
    
    cpd_y2 = TabularCPD(variable='y2', variable_card=2, 
                       values=[[0.05,0.3,0.32,0.29,0.44,0.42,0.45,0.6],
                               [0.95,0.7,0.68,0.71,0.56,0.58,0.55,0.4]],
                       evidence=['x4','x5','x6'],
                       evidence_card=[2,2,2])
    
    cpd_o1 = TabularCPD(variable='o1', variable_card=2,
                       values=[[0.03,0.55,0.6,0.7],
                               [0.97,0.45,0.4,0.3]],
                       evidence=['y1','y2'],
                       evidence_card=[2,2])
    
    # 将有向无环图与条件概率分布表关联
    model.add_cpds(cpd_x1, cpd_x2, cpd_x3,cpd_x4,cpd_x5,cpd_x6,cpd_y1,cpd_y2,cpd_o1)
    
    # 验证模型：检查网络结构和CPD，并验证CPD是否正确定义和总和为1
    model.check_model()
    #value = {'x1':1,'x2':1,'x3':1,'x4':1,'x5':1,'x6':1}
    #value = np.array(value)
    #print(value)
    data = pd.DataFrame(data,index=[0])
    #values = pd.DataFrame(np.random.randint(low=0, high=2, size=(1, 6)),
                          #columns=['x1', 'x2', 'x3', 'x4', 'x5','x6'])
    #(values)
    #predict=model.predict_probability(values)
    predict = model.predict(data)
    predict_value = predict.get_value(0,'o1')
    if(predict_value==1):
        print("result:The car have error")
        result = '1'
    else:
        print("result:The car don't have error")
        result = '0'
    return result

if __name__=='__main__':
    import socket
    import json
    
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    host = '172.17.151.154'
    port = 8000
    s.bind((host,port))
    
    s.listen(5)
    while True:
        print('waiting connecting......')
        c, addr = s.accept()
        print('address'+str(addr))
        data = c.recv(1024)
        #data = json.loads(data.decode('utf-8'))
        data = json.loads(data)
        print(type(data))
        result = BayesianModel(data)
        #result = str(json.dumps(result))
        c.send(result.encode('utf-8'))
        #c.shutdown()
        c.close()
    





