import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')
from sixgill.pipesim import Model
from sixgill.definitions import ALL,ModelComponents, Parameters, Constants
from sixgill.definitions import SystemVariables, ProfileVariables
from collections import defaultdict
import pandas as pd
import os.path
filename = os.path.join(os.path.dirname(__file__), "D:/develop/PG-Pipe/pipe_servers/createfile/pipsfile/2019-12-15 12-33-30-314-model.pips")
model = Model.open(filename)
profile_variables = [
           ProfileVariables.TEMPERATURE,
           ProfileVariables.ELEVATION,
           ProfileVariables.HOLDUP_FRACTION_LIQUID,
           ProfileVariables.PRESSURE,
           ProfileVariables.TOTAL_DISTANCE,
           ProfileVariables.MEAN_VELOCITY_FLUID,
           ProfileVariables.HEAT_CAPACITY_GAS_INSITU,
           ProfileVariables.HEAT_CAPACITY_LIQUID_INSITU,
           ProfileVariables.DENSITY_GAS_INSITU,
           ProfileVariables.DENSITY_LIQUID_INSITU,
           ProfileVariables.FLOWRATE_GAS_INSITU,
]
system_variables = [
            SystemVariables.PRESSURE,
            SystemVariables.TEMPERATURE,
            SystemVariables.VOLUME_FLOWRATE_GAS_STOCKTANK,
]
sim_settings = model.sim_settings
sim_settings[Parameters.SimulationSetting.PIPESEGMENTATIONMAXREPORTINGINTERVAL] = 600
model.sim_settings.global_flow_correlation({
})
model.sim_settings.global_heat_transfer_option({
})
with model.batch_update():
   values = defaultdict(dict)
   values['D404'][Parameters.Source.TEMPERATURE] = 112.874873
   model.set_values(values)
model.save("D:/develop/PG-Pipe/pipe_servers/createfile/pipsfile/2019-12-15 12-33-30-314-model.pips")
model.tasks.networksimulation.reset_conditions()
results =  model.tasks.networksimulation.run(system_variables=system_variables,profile_variables=profile_variables)
for branch,profile in results.profile.items():
    profile_df = pd.DataFrame.from_dict(profile)
    print(format(branch))
    print("!Elevation:",profile_df['Elevation'].tolist())
    print("!Pressure:",profile_df['Pressure'].tolist())
    print("!Temperature:",profile_df['Temperature'].tolist())
    print("!HoldupFractionLiquid:",profile_df['HoldupFractionLiquid'].tolist())
    print("!TotalDistance,:",profile_df['TotalDistance'].tolist())
    print("!BranchEquipment:",profile_df['BranchEquipment'].tolist())
    print("!MeanVelocityFluid:",profile_df['MeanVelocityFluid'].tolist())
    print("!FlowrateGasInSitu:",profile_df['FlowrateGasInSitu'].tolist())
    print("!HeatCapacityGasInSitu:",profile_df['HeatCapacityGasInSitu'].tolist())
    print("!HeatCapacityLiquidInSitu:",profile_df['HeatCapacityLiquidInSitu'].tolist())
    print("!DensityGasInSitu:",profile_df['DensityGasInSitu'].tolist())
    print("!DensityLiquidInSitu:",profile_df['DensityLiquidInSitu'].tolist())
    print(";")
print("&")
param=['Pressure','Temperature','VolumeFlowrateGasStockTank']
new_array = [key for key in results.node["Pressure"]]
for key in param:
    print(key+"!")
    for keykey in new_array:
        print("{}#{}:".format(keykey,results.node[key][keykey]))
    print(";")
model.close()

