???prompt PL/SQL Developer Export Tables for user PGGWMN@YCGGWMN
prompt Created by Administrator on 2019年11月18日
set feedback off
set define off

prompt Creating EARLY_WARNING_TBL...
create table EARLY_WARNING_TBL
(
  earwarid_earwar        NUMBER not null,
  projectid_proaff       VARCHAR2(50),
  layerid_earwar         VARCHAR2(50),
  elementrealname_earwar VARCHAR2(100),
  experience_earwar      VARCHAR2(500),
  propertyid_pro         VARCHAR2(50) not null,
  setting_earwar         NUMBER,
  criticallow_earwar     NUMBER,
  criticalhigh_earwar    NUMBER
)
;
comment on column EARLY_WARNING_TBL.earwarid_earwar
  is '自增，ID';
comment on column EARLY_WARNING_TBL.projectid_proaff
  is '工程备份表编号';
comment on column EARLY_WARNING_TBL.layerid_earwar
  is '关键节点所处的画布编号';
comment on column EARLY_WARNING_TBL.elementrealname_earwar
  is '元件编号';
comment on column EARLY_WARNING_TBL.experience_earwar
  is '对应问题的经验信息';
comment on column EARLY_WARNING_TBL.propertyid_pro
  is '属性表编号，对应该数据进行预警报警';
comment on column EARLY_WARNING_TBL.setting_earwar
  is '工作生产中设置的正常值';
comment on column EARLY_WARNING_TBL.criticallow_earwar
  is '设备的临界点低值';
comment on column EARLY_WARNING_TBL.criticalhigh_earwar
  is '设备的临界点高值';
alter table EARLY_WARNING_TBL
  add constraint PK_EARLY_WARNING_TBL primary key (EARWARID_EARWAR, PROPERTYID_PRO);

prompt Creating ELEMENT_NODE_TBL...
create table ELEMENT_NODE_TBL
(
  nodeid_ndl       NUMBER not null,
  nodex_ndl        NUMBER,
  nodey_ndl        NUMBER,
  projectid_proaff NUMBER,
  layerid_ele      NUMBER,
  nodenum_ndl      VARCHAR2(100)
)
;
comment on column ELEMENT_NODE_TBL.nodeid_ndl
  is '自增，ID';
comment on column ELEMENT_NODE_TBL.nodex_ndl
  is 'NODE节点的X位置';
comment on column ELEMENT_NODE_TBL.nodey_ndl
  is 'NODE节点的Y位置';
comment on column ELEMENT_NODE_TBL.projectid_proaff
  is '工程备份表编号';
comment on column ELEMENT_NODE_TBL.layerid_ele
  is '元件所在的画布表编号';
comment on column ELEMENT_NODE_TBL.nodenum_ndl
  is 'NODE节点的编号';
alter table ELEMENT_NODE_TBL
  add constraint PK_ELEMENT_NODE_TBL primary key (NODEID_NDL);

prompt Creating ELEMENT_TBL...
create table ELEMENT_TBL
(
  elementid_ele       NUMBER not null,
  nodestar_ele        VARCHAR2(100),
  nodeend_ele         VARCHAR2(100),
  starx_ele           NUMBER,
  stary_ele           NUMBER,
  projectid_proaff    NUMBER,
  layerid_ele         VARCHAR2(50),
  elementrealname_ele VARCHAR2(100),
  elementtype_ele     VARCHAR2(100),
  elementisstate      NUMBER,
  rotate_ele          NUMBER
)
;
comment on column ELEMENT_TBL.elementid_ele
  is '自增，ID';
comment on column ELEMENT_TBL.nodestar_ele
  is '双节点元件起始节点';
comment on column ELEMENT_TBL.nodeend_ele
  is '双节点元件结束节点';
comment on column ELEMENT_TBL.starx_ele
  is '只有类型为井才有';
comment on column ELEMENT_TBL.stary_ele
  is '只有类型为井才有';
comment on column ELEMENT_TBL.projectid_proaff
  is '工程备份表编号';
comment on column ELEMENT_TBL.layerid_ele
  is '元件所在的画布表编号';
comment on column ELEMENT_TBL.elementrealname_ele
  is '元件编号';
comment on column ELEMENT_TBL.elementtype_ele
  is '元件类别';
comment on column ELEMENT_TBL.elementisstate
  is '记录设备的状态0：未改动,1：已绑定，2：已绑定但需要用户自觉判断';
comment on column ELEMENT_TBL.rotate_ele
  is '元件旋转度数';
alter table ELEMENT_TBL
  add constraint PK_ELEMENT_TBL primary key (ELEMENTID_ELE);

prompt Creating ELETYPE_PROPERTY_TBL...
create table ELETYPE_PROPERTY_TBL
(
  eleproid_elepro       NUMBER not null,
  propertyid_pro        NUMBER,
  eletype_elepro        VARCHAR2(20),
  eletype_number_elepro NUMBER
)
;
comment on column ELETYPE_PROPERTY_TBL.eleproid_elepro
  is '自增，ID';
comment on column ELETYPE_PROPERTY_TBL.propertyid_pro
  is '属性表编号';
comment on column ELETYPE_PROPERTY_TBL.eletype_elepro
  is '元件种类名称';
comment on column ELETYPE_PROPERTY_TBL.eletype_number_elepro
  is '属性在列表中显示的先后顺序';
alter table ELETYPE_PROPERTY_TBL
  add constraint PK_ELETYPE_PROPERTY_TBL primary key (ELEPROID_ELEPRO);

prompt Creating LAYER_TBL...
create table LAYER_TBL
(
  layerkeyid_grp     NUMBER not null,
  layerelementid_grp VARCHAR2(100),
  layerid_grp        VARCHAR2(50),
  projectid_proaff   NUMBER,
  layerpid_grp       VARCHAR2(100)
)
;
comment on column LAYER_TBL.layerkeyid_grp
  is '自增，ID';
comment on column LAYER_TBL.layerelementid_grp
  is '某个站场所生成的画布';
comment on column LAYER_TBL.layerid_grp
  is '画布编号';
comment on column LAYER_TBL.projectid_proaff
  is '工程备份表编号';
comment on column LAYER_TBL.layerpid_grp
  is '上层级画布编号，如果是主画布写0';
alter table LAYER_TBL
  add constraint PK_LAYER_TBL primary key (LAYERKEYID_GRP);

prompt Creating OPERATION_INDEX_TBL...
create table OPERATION_INDEX_TBL
(
  operaindid_operaind   NUMBER not null,
  operaid_opera         NUMBER,
  operaindname_operaind VARCHAR2(50),
  coeffixient_operaind  NUMBER
)
;
comment on column OPERATION_INDEX_TBL.operaindid_operaind
  is '自增，ID';
comment on column OPERATION_INDEX_TBL.operaid_opera
  is '所对应的优选方案编号';
comment on column OPERATION_INDEX_TBL.operaindname_operaind
  is '指标名称';
comment on column OPERATION_INDEX_TBL.coeffixient_operaind
  is '系数';
alter table OPERATION_INDEX_TBL
  add constraint PK_OPERATION_INDEX_TBL primary key (OPERAINDID_OPERAIND);

prompt Creating OPERATION_RESULT_TBL...
create table OPERATION_RESULT_TBL
(
  operaresid_operares NUMBER not null,
  operaid_opera       NUMBER,
  workid_work         NUMBER,
  predrop_operares    NUMBER,
  flow_operares       NUMBER,
  aquocom_operares    NUMBER,
  efficient_operares  NUMBER,
  relevancy_operares  NUMBER,
  sortnum_operares    NUMBER
)
;
comment on column OPERATION_RESULT_TBL.operaresid_operares
  is '自增，ID';
comment on column OPERATION_RESULT_TBL.operaid_opera
  is '所对应的优选方案编号';
comment on column OPERATION_RESULT_TBL.workid_work
  is '工况表编号';
comment on column OPERATION_RESULT_TBL.predrop_operares
  is '管道压降指数';
comment on column OPERATION_RESULT_TBL.flow_operares
  is '最大输量';
comment on column OPERATION_RESULT_TBL.aquocom_operares
  is '水合物危害指数';
comment on column OPERATION_RESULT_TBL.efficient_operares
  is '运行效率指数';
comment on column OPERATION_RESULT_TBL.relevancy_operares
  is '综合关联度值';
comment on column OPERATION_RESULT_TBL.sortnum_operares
  is '根据综合关联度大小进行排序';
alter table OPERATION_RESULT_TBL
  add constraint PK_OPERATION_RESULT_TBL primary key (OPERARESID_OPERARES);

prompt Creating OPERATION_TBL...
create table OPERATION_TBL
(
  operaid_opera       NUMBER not null,
  operaname_opera     VARCHAR2(100),
  projectid_proaff    NUMBER,
  operausername_opera VARCHAR2(50),
  createdate_sim      DATE,
  remark_opera        VARCHAR2(500)
)
;
comment on column OPERATION_TBL.operaid_opera
  is '自增，ID';
comment on column OPERATION_TBL.operaname_opera
  is '方案名称';
comment on column OPERATION_TBL.projectid_proaff
  is '工程备份表编号';
comment on column OPERATION_TBL.operausername_opera
  is '创建用户名';
comment on column OPERATION_TBL.createdate_sim
  is '方案创建时间';
comment on column OPERATION_TBL.remark_opera
  is '该方案创建时的填写备注';
alter table OPERATION_TBL
  add constraint PK_OPERATION_TBL primary key (OPERAID_OPERA);

prompt Creating OPTIMIZE_TBL...
create table OPTIMIZE_TBL
(
  optimid_optim       VARCHAR2(50) not null,
  optimname_optim     VARCHAR2(100),
  optimusername_optim VARCHAR2(50),
  workid_work         NUMBER,
  workidend_work      NUMBER,
  createdate_optim    DATE,
  remark_optim        VARCHAR2(500)
)
;
comment on column OPTIMIZE_TBL.optimid_optim
  is '唯一标识';
comment on column OPTIMIZE_TBL.optimname_optim
  is '方案名称';
comment on column OPTIMIZE_TBL.optimusername_optim
  is '创建用户名';
comment on column OPTIMIZE_TBL.workid_work
  is '所被优化的工况表编号';
comment on column OPTIMIZE_TBL.workidend_work
  is '优化后工况编号';
comment on column OPTIMIZE_TBL.createdate_optim
  is '方案创建时间';
comment on column OPTIMIZE_TBL.remark_optim
  is '该方案创建时的填写备注';
alter table OPTIMIZE_TBL
  add constraint PK_OPTIMIZE_TBL primary key (OPTIMID_OPTIM);

prompt Creating PROJECT_AFFILIATED_TBL...
create table PROJECT_AFFILIATED_TBL
(
  projectid_proaff   NUMBER not null,
  projectid_pro      NUMBER,
  createdate_proaff  DATE,
  prousername_proaff VARCHAR2(50),
  remark_proaff      VARCHAR2(500),
  issave_proaff      NUMBER default 2
)
;
comment on column PROJECT_AFFILIATED_TBL.projectid_proaff
  is '自增，ID';
comment on column PROJECT_AFFILIATED_TBL.projectid_pro
  is '工程主表编号';
comment on column PROJECT_AFFILIATED_TBL.createdate_proaff
  is '备份时间';
comment on column PROJECT_AFFILIATED_TBL.prousername_proaff
  is '备份用户名';
comment on column PROJECT_AFFILIATED_TBL.remark_proaff
  is '该工程备份时的填写备注';
comment on column PROJECT_AFFILIATED_TBL.issave_proaff
  is '0:之后保存时项目可以删掉；1：保存项目时不能删除，第一次创建项目时为1;  2 : 项目未保存';
alter table PROJECT_AFFILIATED_TBL
  add constraint PK_PROJECT_AFFILIATED_TBL primary key (PROJECTID_PROAFF);

prompt Creating PROJECT_TBL...
create table PROJECT_TBL
(
  projectid_pro   NUMBER not null,
  projectname_pro VARCHAR2(100),
  createdate_pro  DATE,
  prousername_pro VARCHAR2(50),
  remark_pro      VARCHAR2(500)
)
;
comment on column PROJECT_TBL.projectid_pro
  is '自增，ID';
comment on column PROJECT_TBL.projectname_pro
  is '工程名称，不能重复';
comment on column PROJECT_TBL.createdate_pro
  is '创建时间';
comment on column PROJECT_TBL.prousername_pro
  is '用户名';
comment on column PROJECT_TBL.remark_pro
  is '该工程创建时的填写备注';
alter table PROJECT_TBL
  add constraint PK_PROJECT_TBL primary key (PROJECTID_PRO);

prompt Creating PROPERTY_TBL...
create table PROPERTY_TBL
(
  propertyid_pro     NUMBER not null,
  propertycnname_pro VARCHAR2(50),
  propertyname_pro   VARCHAR2(50),
  propertyunit_pro   VARCHAR2(50),
  prodefval_pro      VARCHAR2(50),
  remark_pro         VARCHAR2(800),
  editable_pro       NUMBER,
  opendilaog_pro     NUMBER,
  show_pro           NUMBER
)
;
comment on column PROPERTY_TBL.propertyid_pro
  is '自增，ID';
comment on column PROPERTY_TBL.propertycnname_pro
  is '属性中文名称';
comment on column PROPERTY_TBL.propertyname_pro
  is '属性名称';
comment on column PROPERTY_TBL.propertyunit_pro
  is '属性单位';
comment on column PROPERTY_TBL.prodefval_pro
  is '属性缺省值';
comment on column PROPERTY_TBL.remark_pro
  is '属性的填写备注';
comment on column PROPERTY_TBL.editable_pro
  is '是否允许手动编辑,0:false,1:true';
comment on column PROPERTY_TBL.opendilaog_pro
  is '是否进一步打开弹出框进行编辑,0:false,1:true';
comment on column PROPERTY_TBL.show_pro
  is '是否在属性框展示,0:false,1:true';
alter table PROPERTY_TBL
  add constraint PK_PROPERTY_TBL primary key (PROPERTYID_PRO);

prompt Creating PROPERTY_VALUE_TBL...
create table PROPERTY_VALUE_TBL
(
  provalueid_proval   NUMBER not null,
  workid_work         NUMBER,
  propertyid_pro      NUMBER,
  elementrealname_ele VARCHAR2(100),
  provalue_proval     VARCHAR2(150)
)
;
comment on column PROPERTY_VALUE_TBL.provalueid_proval
  is '自增，ID';
comment on column PROPERTY_VALUE_TBL.workid_work
  is '工况表编号';
comment on column PROPERTY_VALUE_TBL.propertyid_pro
  is '属性表编号';
comment on column PROPERTY_VALUE_TBL.elementrealname_ele
  is '元件编号';
comment on column PROPERTY_VALUE_TBL.provalue_proval
  is '属性值,数组用逗号隔开';
alter table PROPERTY_VALUE_TBL
  add constraint PK_PROPERTY_VALUE_TBL primary key (PROVALUEID_PROVAL);

prompt Creating SIMELE_RESULT_TBL...
create table SIMELE_RESULT_TBL
(
  simresid_simres   NUMBER not null,
  simulationid_sim  NUMBER,
  eleproid_simres   VARCHAR2(50),
  elementid_simres  VARCHAR2(50),
  provalue_simres   VARCHAR2(150),
  simresname_simres VARCHAR2(50)
)
;
comment on column SIMELE_RESULT_TBL.simresid_simres
  is '自增，ID';
comment on column SIMELE_RESULT_TBL.simulationid_sim
  is '仿真模拟方案表编号';
comment on column SIMELE_RESULT_TBL.eleproid_simres
  is '属性与元件种类表编号，如果属性表存在该属性就填写（例如，设备的压力、温度、流量等参数），如果不存在就不填写，（类似管道的模拟后剖面数据）';
comment on column SIMELE_RESULT_TBL.elementid_simres
  is '设备编号';
comment on column SIMELE_RESULT_TBL.provalue_simres
  is '属性值,数组用逗号隔开';
comment on column SIMELE_RESULT_TBL.simresname_simres
  is '属性名称';
alter table SIMELE_RESULT_TBL
  add constraint PK_SIMELE_RESULT_TBL primary key (SIMRESID_SIMRES);

prompt Creating SIMULATION_TBL...
create table SIMULATION_TBL
(
  simulationid_sim   NUMBER not null,
  projectid_proaff   NUMBER,
  simulationname_sim VARCHAR2(100),
  simsource_sim      VARCHAR2(50),
  simusername_sim    VARCHAR2(50),
  createdate_sim     DATE,
  remark_sim         VARCHAR2(500)
)
;
comment on column SIMULATION_TBL.simulationid_sim
  is '自增，ID';
comment on column SIMULATION_TBL.projectid_proaff
  is '工程备份表编号';
comment on column SIMULATION_TBL.simulationname_sim
  is '方案名称';
comment on column SIMULATION_TBL.simsource_sim
  is '来自某个工况';
comment on column SIMULATION_TBL.simusername_sim
  is '创建用户名';
comment on column SIMULATION_TBL.createdate_sim
  is '方案创建时间';
comment on column SIMULATION_TBL.remark_sim
  is '该方案创建时的填写备注';
alter table SIMULATION_TBL
  add constraint PK_SIMULATION_TBL primary key (SIMULATIONID_SIM);

prompt Creating WORKINGCONDITION_TBL...
create table WORKINGCONDITION_TBL
(
  workid_work       NUMBER not null,
  workusername_work VARCHAR2(50),
  projectid_proaff  NUMBER,
  createdate_work   DATE,
  worktype_work     NUMBER,
  isacquiesce_work  NUMBER,
  remark_proaff     VARCHAR2(500),
  workname_work     VARCHAR2(255)
)
;
comment on column WORKINGCONDITION_TBL.workid_work
  is '自增，ID';
comment on column WORKINGCONDITION_TBL.workusername_work
  is '用户名';
comment on column WORKINGCONDITION_TBL.projectid_proaff
  is '工程备份表编号';
comment on column WORKINGCONDITION_TBL.createdate_work
  is '工况创建时间';
comment on column WORKINGCONDITION_TBL.worktype_work
  is '0:普通工况信息，1：用户自建工况，2：优化后形成新的一套工况，';
comment on column WORKINGCONDITION_TBL.isacquiesce_work
  is '是否是默认工况
0:是 其他：不是';
comment on column WORKINGCONDITION_TBL.remark_proaff
  is '创建时填写备注';
alter table WORKINGCONDITION_TBL
  add constraint PK_WORKINGCONDITION_TBL primary key (WORKID_WORK);

prompt Loading EARLY_WARNING_TBL...
prompt Table is empty
prompt Loading ELEMENT_NODE_TBL...
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (189, 231, 89, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (190, 331, 89, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (185, 231, 89, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (186, 331, 89, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (187, 375, 91, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (188, 475, 91, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (191, 375, 91, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (192, 475, 91, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (193, 231, 89, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (194, 331, 89, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (195, 375, 91, 84, null, null);
insert into ELEMENT_NODE_TBL (nodeid_ndl, nodex_ndl, nodey_ndl, projectid_proaff, layerid_ele, nodenum_ndl)
values (196, 475, 91, 84, null, null);
commit;
prompt 12 records loaded
prompt Loading ELEMENT_TBL...
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (130, 'ND0', 'ND1', 281, 89, 84, 'defaultLayer', 'PL0', '3', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (124, 'ND0', 'ND1', 281, 89, 84, 'defaultLayer', 'PL0', '3', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (125, null, null, 421, 70, 84, 'defaultLayer', 'STATION0', '8', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (126, 'ND2', 'ND3', 425, 91, 84, 'svgLayer_STATION0', 'PL1', '3', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (127, 'ND0', 'ND1', 281, 89, 84, 'defaultLayer', 'PL0', '3', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (128, null, null, 421, 70, 84, 'defaultLayer', 'STATION0', '8', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (129, 'ND2', 'ND3', 425, 91, 84, 'svgLayer_STATION0', 'PL1', '3', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (131, null, null, 421, 70, 84, 'defaultLayer', 'STATION0', '8', null, null);
insert into ELEMENT_TBL (elementid_ele, nodestar_ele, nodeend_ele, starx_ele, stary_ele, projectid_proaff, layerid_ele, elementrealname_ele, elementtype_ele, elementisstate, rotate_ele)
values (132, 'ND2', 'ND3', 425, 91, 84, 'svgLayer_STATION0', 'PL1', '3', null, null);
commit;
prompt 9 records loaded
prompt Loading ELETYPE_PROPERTY_TBL...
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (1, 1, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (2, 2, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (3, 3, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (4, 4, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (5, 5, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (6, 6, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (7, 7, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (8, 8, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (9, 9, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (10, 10, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (11, 11, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (12, 12, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (13, 13, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (14, 14, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (15, 15, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (16, 16, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (17, 17, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (18, 18, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (19, 1, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (20, 19, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (21, 20, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (22, 21, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (23, 22, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (24, 23, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (25, 24, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (26, 25, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (27, 26, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (28, 27, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (29, 28, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (30, 29, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (31, 30, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (32, 31, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (33, 1, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (34, 32, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (35, 33, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (36, 34, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (37, 35, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (38, 36, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (39, 37, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (40, 38, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (41, 39, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (42, 1, 'WellDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (43, 40, 'WellDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (44, 41, 'WellDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (45, 42, 'WellDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (46, 43, 'WellDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (47, 44, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (48, 45, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (49, 46, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (50, 47, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (51, 48, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (52, 49, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (53, 50, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (54, 51, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (55, 51, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (56, 51, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (57, 51, 'WellDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (58, 51, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (59, 54, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (60, 53, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (61, 52, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (62, 55, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (63, 56, 'PLDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (64, 54, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (65, 53, 'SwitchDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (66, 57, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (67, 58, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (68, 59, 'HeatDecice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (69, 64, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (70, 63, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (71, 62, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (72, 61, 'StationDevice', null);
insert into ELETYPE_PROPERTY_TBL (eleproid_elepro, propertyid_pro, eletype_elepro, eletype_number_elepro)
values (73, 60, 'StationDevice', null);
commit;
prompt 73 records loaded
prompt Loading LAYER_TBL...
prompt Table is empty
prompt Loading OPERATION_INDEX_TBL...
prompt Table is empty
prompt Loading OPERATION_RESULT_TBL...
prompt Table is empty
prompt Loading OPERATION_TBL...
prompt Table is empty
prompt Loading OPTIMIZE_TBL...
prompt Table is empty
prompt Loading PROJECT_AFFILIATED_TBL...
insert into PROJECT_AFFILIATED_TBL (projectid_proaff, projectid_pro, createdate_proaff, prousername_proaff, remark_proaff, issave_proaff)
values (83, 233, to_date('18-11-2019 09:17:34', 'dd-mm-yyyy hh24:mi:ss'), null, '备注', 0);
insert into PROJECT_AFFILIATED_TBL (projectid_proaff, projectid_pro, createdate_proaff, prousername_proaff, remark_proaff, issave_proaff)
values (85, 233, null, null, null, 2);
insert into PROJECT_AFFILIATED_TBL (projectid_proaff, projectid_pro, createdate_proaff, prousername_proaff, remark_proaff, issave_proaff)
values (84, 233, null, null, null, 0);
insert into PROJECT_AFFILIATED_TBL (projectid_proaff, projectid_pro, createdate_proaff, prousername_proaff, remark_proaff, issave_proaff)
values (86, null, null, '测试用户', null, 2);
insert into PROJECT_AFFILIATED_TBL (projectid_proaff, projectid_pro, createdate_proaff, prousername_proaff, remark_proaff, issave_proaff)
values (87, null, null, '测试用户', null, 2);
insert into PROJECT_AFFILIATED_TBL (projectid_proaff, projectid_pro, createdate_proaff, prousername_proaff, remark_proaff, issave_proaff)
values (88, null, null, '测试用户', null, 2);
commit;
prompt 6 records loaded
prompt Loading PROJECT_TBL...
insert into PROJECT_TBL (projectid_pro, projectname_pro, createdate_pro, prousername_pro, remark_pro)
values (233, '工程1', to_date('18-11-2019 09:02:22', 'dd-mm-yyyy hh24:mi:ss'), null, null);
commit;
prompt 1 records loaded
prompt Loading PROPERTY_TBL...
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (64, '外输备用甲醇泵当日累积合计', null, 'm3', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (1, '名称', 'Name', null, null, 'Unique name of the choke.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (2, '是否激活', 'Active', null, null, 'Select this check box to activate the choke so that it will be used during simulation. Clear the check box to deactivate and the choke will be bypassed during simulation', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (3, '亚临界系数', 'Subcritical Correlation', null, null, 'Select a correlation from the list. (All correlations except Mechanistic and API14B require hydrocarbon liquids at Stock tank conditions.)', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (4, '临界系数', 'Critical Correlation', null, null, 'Select a correlation from the list. Can be used to set the critical flowrate. This may not match the subcritical flow at the critical pressure ratio, so the subcritical flow correlation is adjusted to ensure that the flow is correct at the critical pressure.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (5, '直径', 'Bean size', null, null, 'Enter the diameter of the choke bean. The bean size represents the diameter of the available flow area assuming that the constriction is circular.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (6, '上游管道ID', 'Upstream pipe ID', null, null, 'Enter the inside diameter of the pipe upstream of the choke.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (7, '井筒位置', 'Measured depth', null, null, 'Downhole location of the choke', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (8, '流量系数', 'Gas Phase flow coefficient', null, null, '(Used in the Mechanistic correlation) Flow coefficient for the gas phase. For API14B compatibility, set this to 0.9.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (9, '气相流量系数', 'Liquid Phase flow coefficient', null, null, '(Used in the Mechanistic correlation) Flow coefficient for the liquid phase. For API14B compatibility, set this to 0.85.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (10, '泄流系数', 'Discharge coefficient', null, null, 'Used to calculate the flow coefficients.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (11, '比热容比', 'Fluid heat capacity ratio (Cp/Cv)', null, null, 'Normally calculated, but can be specified. The valid range is 0.7 to 2. Typically it is 1.26 for a natural gas, 1.4 for a diatomic gas. It is used to calculate the Critical pressure ratio if that is set to 0.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (12, '临界点', 'Y at critical point', null, null, 'Gas expansion factor at critical flow. Normally, it is calculated, but it can be specified. The valid range is 0.5 to 1. It is used to modify the pressure drop equation to allow for gas compressibility.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (13, '识别是否超临界', 'Identification of Critical and Supercritical Flow', null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (14, '流量', 'Flowrate', null, null, 'Flowrate to identify critical flow.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (15, '压比', 'Pressure ratio', null, null, 'Pressure ratio to identify critical flow.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (16, '上游声速', 'Sonic upstream velocity', null, null, 'Sonic upstream velocity to identify critical flow.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (17, '下游声速', 'Sonic downstream velocity', null, null, 'Sonic downstream velocity to identify critical flow', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (18, '亚临界流调节系数', 'Adjust sub-critical correlation', null, null, 'Adjust subcritical correlation to match flowrate predicted by critical correlation.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (19, '敷设环境', 'Environment', null, null, 'Sets the type of flowline to Land (air data used) or Subsea (metocean data used). In the network diagram, land flowlines are displayed in black while subsea flowlines are displayed in dark blue.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (20, '传热类型', 'Mode', null, null, 'Based on data availability and need, you can switch between Simple and Detailed mode. To switch to the detailed model, click Detailed. Click Simple to return to the simple model (the detailed data will be deleted). Detailed mode has an additional tab for detailed heat transfer modeling.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (21, '环境数据', 'Override global environmental data', null, null, 'Defines environmental data such as local ambient temperature.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (22, '内径', 'Inside diameter', null, null, 'Inside diameter', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (23, '管外径', 'Wall thickness', null, null, 'Select and specify either wall thickness or outside diameter (excluding any coatings).', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (24, '粗糙度', 'Roughness', null, null, 'Enter the typical value for the absolute pipe roughness based on the material type. The default value is 0.001 inches (0.0254 mm).', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (25, '地形系数', 'Rate of undulations', null, null, 'An artificial factor used to introduce undulations into the flowline (specific to simple mode only). Undulation is typically used for a horizontal pipe to capture terrain effects (unevenness of the underlying surface) and result in a higher overall pressure drop due to the fact that liquid holdup is higher in inclined sections and lower in declined sections resulting in less pressure recovery. Enter the total change in elevation for every 1,000 units of length. (To model a totally flat flowline, enter 0.) Undulations capture terrain effects and result in a higher overall pressure drop.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (26, '水平距离/测深', 'Horizontal distance', null, null, 'Select either the horizontal distance or length to specify the distance covered by the flowline from start to end.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (27, '高程变化', 'Elevation difference', null, null, 'Change in elevation between the start and end of the flowline object. Enter a negative value for a downhill flowline, or a positive value for an uphill flowline. Elevation changes are relative to the object itself and not influenced by adjacent flowlines.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (28, '环境温度', 'Ambient temperature', null, null, 'Ambient temperature for the fluid surrounding the flowline.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (29, '总传热系数类型', 'U Value type', null, null, 'Heat transfer coefficient (U Value) is a measure of thermal property of pipe (with/without coating) and surrounding material. In simple mode, a known overall heat transfer coefficient is used. Available options are: Insulated, Coated, Bare (in air), Bare (in water), and User supplied.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (30, '总传热系数值', 'Heat transfer coefficient', null, null, 'Based on selected U value type, the corresponding pre-defined heat transfer coefficient is filled in. Enter a value if you have selected U value type as User supplied.', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (31, '液壁对流换热系数', 'Inside film coefficient', null, null, 'Click the appropriate option to either Include the Inside film coefficient (within the supplied heat transfer coefficient above) or Calculate separately. Calculation is performed based on selected methods (under Home ? Simulation settings ? Heat transfer tab)', 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (32, '进站温度', null, '℃', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (33, '出站温度', null, '℃', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (34, '进站压力', null, 'Mpa', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (35, '出站压力', null, 'Mpa', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (36, '出站压力设定值', null, 'Mpa', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (37, '出站流量当日累积', null, '万方', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (38, '出站流量当日累积修正', null, 'm3', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (39, '出站管线切断阀状态', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (40, '瞬时流量', null, 'km3/d', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (41, '井口压力', null, 'Mpa', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (42, '井口压力设定值', null, 'Mpa', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (43, '井口温度', null, '℃', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (44, '出口温度', null, '℃', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (45, '进口温度', null, '℃', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (46, '出口压力', null, 'Mpa', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (47, '进口压力', null, 'Mpa', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (48, '燃料气入口流量', null, 'm3/h', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (49, '燃料气当日累计', null, '万方', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (50, '燃料气当日累计修正', null, 'm3', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (51, '实际名称', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (52, '管道材料', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (53, '设计压力', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (54, '许用压力', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (55, '进口高程', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (56, '出口高程', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (57, '进口尺寸', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (58, '出口尺寸', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (59, '额定功率', null, null, null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (60, '外输甲醇泵当日累积', null, 'm3', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (61, '外输甲醇泵当日累积修正', null, 'm3', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (62, '外输备用甲醇泵当日累积', null, 'm3', null, null, 1, 0, 1);
insert into PROPERTY_TBL (propertyid_pro, propertycnname_pro, propertyname_pro, propertyunit_pro, prodefval_pro, remark_pro, editable_pro, opendilaog_pro, show_pro)
values (63, '外输备用甲醇泵当日累积修正', null, 'm3', null, null, 1, 0, 1);
commit;
prompt 64 records loaded
prompt Loading PROPERTY_VALUE_TBL...
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2574, 115, 0, 'PL0', 'PL0');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2575, 115, 1, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2576, 115, 2, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2577, 115, 4, 'PL0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2578, 115, 7, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2579, 115, 8, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2580, 115, 9, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2581, 115, 10, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2582, 115, 11, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2583, 115, 12, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2584, 115, 13, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2585, 115, 14, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2586, 115, 15, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2587, 115, 16, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2588, 115, 17, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2589, 115, 18, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2590, 115, 19, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2591, 115, 20, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2592, 115, 21, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2593, 115, 22, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2594, 115, 23, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2595, 115, 24, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2596, 115, 25, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2597, 115, 26, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2598, 115, 0, 'STATION0', 'STATION0');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2599, 115, 1, 'STATION0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2600, 115, 2, 'STATION0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2601, 115, 4, 'STATION0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2602, 115, 0, 'PL1', 'PL1');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2603, 115, 1, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2604, 115, 2, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2605, 115, 4, 'PL1', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2606, 115, 7, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2607, 115, 8, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2608, 115, 9, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2609, 115, 10, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2610, 115, 11, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2611, 115, 12, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2612, 115, 13, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2613, 115, 14, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2614, 115, 15, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2615, 115, 16, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2616, 115, 17, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2617, 115, 18, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2618, 115, 19, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2619, 115, 20, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2620, 115, 21, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2621, 115, 22, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2622, 115, 23, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2623, 115, 24, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2624, 115, 25, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2625, 115, 26, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2626, 116, 4, 'PL0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2627, 116, 7, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2628, 116, 10, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2629, 116, 11, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2630, 116, 12, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2631, 116, 13, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2632, 116, 14, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2633, 116, 15, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2634, 116, 16, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2635, 116, 17, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2636, 116, 18, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2637, 116, 19, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2638, 116, 20, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2639, 116, 21, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2640, 116, 22, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2641, 116, 23, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2642, 116, 24, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2643, 116, 25, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2644, 116, 26, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2645, 116, 4, 'STATION0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2646, 116, 4, 'PL1', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2647, 116, 7, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2648, 116, 10, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2649, 116, 11, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2650, 116, 12, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2651, 116, 13, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2652, 116, 14, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2653, 116, 15, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2654, 116, 16, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2655, 116, 17, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2656, 116, 18, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2657, 116, 19, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2658, 116, 20, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2659, 116, 21, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2660, 116, 22, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2661, 116, 23, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2662, 116, 24, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2663, 116, 25, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2664, 116, 26, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2665, 117, 0, 'PL0', 'PL0');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2666, 117, 1, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2667, 117, 2, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2668, 117, 4, 'PL0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2669, 117, 7, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2670, 117, 8, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2671, 117, 9, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2672, 117, 10, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2673, 117, 11, 'PL0', null);
commit;
prompt 100 records committed...
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2674, 117, 12, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2675, 117, 13, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2676, 117, 14, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2677, 117, 15, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2678, 117, 16, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2679, 117, 17, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2680, 117, 18, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2681, 117, 19, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2682, 117, 20, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2683, 117, 21, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2684, 117, 22, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2685, 117, 23, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2686, 117, 24, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2687, 117, 25, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2688, 117, 26, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2689, 117, 0, 'STATION0', 'STATION0');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2690, 117, 1, 'STATION0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2691, 117, 2, 'STATION0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2692, 117, 4, 'STATION0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2693, 117, 0, 'PL1', 'PL1');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2694, 117, 1, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2695, 117, 2, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2696, 117, 4, 'PL1', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2697, 117, 7, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2698, 117, 8, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2699, 117, 9, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2700, 117, 10, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2701, 117, 11, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2702, 117, 12, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2703, 117, 13, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2704, 117, 14, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2705, 117, 15, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2706, 117, 16, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2707, 117, 17, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2708, 117, 18, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2709, 117, 19, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2710, 117, 20, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2711, 117, 21, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2712, 117, 22, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2713, 117, 23, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2714, 117, 24, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2715, 117, 25, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2716, 117, 26, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2717, 118, 4, 'PL0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2718, 118, 7, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2719, 118, 10, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2720, 118, 11, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2721, 118, 12, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2722, 118, 13, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2723, 118, 14, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2724, 118, 15, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2725, 118, 16, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2726, 118, 17, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2727, 118, 18, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2728, 118, 19, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2729, 118, 20, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2730, 118, 21, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2731, 118, 22, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2732, 118, 23, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2733, 118, 24, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2734, 118, 25, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2735, 118, 26, 'PL0', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2736, 118, 4, 'STATION0', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2737, 118, 4, 'PL1', 'true');
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2738, 118, 7, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2739, 118, 10, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2740, 118, 11, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2741, 118, 12, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2742, 118, 13, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2743, 118, 14, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2744, 118, 15, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2745, 118, 16, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2746, 118, 17, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2747, 118, 18, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2748, 118, 19, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2749, 118, 20, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2750, 118, 21, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2751, 118, 22, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2752, 118, 23, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2753, 118, 24, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2754, 118, 25, 'PL1', null);
insert into PROPERTY_VALUE_TBL (provalueid_proval, workid_work, propertyid_pro, elementrealname_ele, provalue_proval)
values (2755, 118, 26, 'PL1', null);
commit;
prompt 182 records loaded
prompt Loading SIMELE_RESULT_TBL...
prompt Table is empty
prompt Loading SIMULATION_TBL...
prompt Table is empty
prompt Loading WORKINGCONDITION_TBL...
insert into WORKINGCONDITION_TBL (workid_work, workusername_work, projectid_proaff, createdate_work, worktype_work, isacquiesce_work, remark_proaff, workname_work)
values (116, null, 83, to_date('16-11-2019 23:38:00', 'dd-mm-yyyy hh24:mi:ss'), 0, null, 'fsdfasf', 'fsdfasf');
insert into WORKINGCONDITION_TBL (workid_work, workusername_work, projectid_proaff, createdate_work, worktype_work, isacquiesce_work, remark_proaff, workname_work)
values (115, null, 83, to_date('16-11-2019 23:37:41', 'dd-mm-yyyy hh24:mi:ss'), 0, null, '默认工况', '默认工况');
insert into WORKINGCONDITION_TBL (workid_work, workusername_work, projectid_proaff, createdate_work, worktype_work, isacquiesce_work, remark_proaff, workname_work)
values (117, null, 83, to_date('16-11-2019 23:37:41', 'dd-mm-yyyy hh24:mi:ss'), 0, null, '默认工况', '默认工况');
insert into WORKINGCONDITION_TBL (workid_work, workusername_work, projectid_proaff, createdate_work, worktype_work, isacquiesce_work, remark_proaff, workname_work)
values (118, null, 83, to_date('16-11-2019 23:38:00', 'dd-mm-yyyy hh24:mi:ss'), 0, null, 'fsdfasf', 'fsdfasf');
insert into WORKINGCONDITION_TBL (workid_work, workusername_work, projectid_proaff, createdate_work, worktype_work, isacquiesce_work, remark_proaff, workname_work)
values (119, null, 83, to_date('16-11-2019 23:37:41', 'dd-mm-yyyy hh24:mi:ss'), 0, null, '默认工况', '默认工况');
insert into WORKINGCONDITION_TBL (workid_work, workusername_work, projectid_proaff, createdate_work, worktype_work, isacquiesce_work, remark_proaff, workname_work)
values (120, null, 83, to_date('16-11-2019 23:38:00', 'dd-mm-yyyy hh24:mi:ss'), 0, null, 'fsdfasf', 'fsdfasf');
commit;
prompt 6 records loaded

set feedback on
set define on
prompt Done
