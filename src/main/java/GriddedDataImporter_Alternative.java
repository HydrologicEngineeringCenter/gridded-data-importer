/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rma.io.RmaFile;
import hec.model.OutputVariable;
import hec2.model.DataLocation;
import hec2.plugin.model.ComputeOptions;
import hec2.plugin.selfcontained.SelfContainedPluginAlt;
import org.jdom.Document;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WatPowerUser
 */
public class GriddedDataImporter_Alternative extends SelfContainedPluginAlt{
    //region Fields
    private String _pluginVersion;
    List<DataLocation> _inputDataLocations;
    List<DataLocation> _outputDataLocations;
    private static final String DocumentRoot = "FIRO_WFP_Alternative";
    private static final String OutputVariableElement = "OutputVariables";
    private static final String AlternativeNameAttribute = "Name";
    private static final String AlternativeDescriptionAttribute = "Desc";
    private ComputeOptions _computeOptions;
    private List<OutputVariable> _outputVariables;
    //endregion
    //region Constructors
    public GriddedDataImporter_Alternative(){
        super();
    }
    public GriddedDataImporter_Alternative(String name){
        this();
        setName(name);
    }
    //endregion
    //region Getters and Setters
    @Override
    public int getModelCount() {
        return 1;
    }
    public List<DataLocation> getInputDataLocations(){
        //construct input data locations.
        if(_inputDataLocations==null ||_inputDataLocations.isEmpty()){
            _inputDataLocations = defaultInputDataLocations();
        }
        return _inputDataLocations;
    }
    public List<DataLocation> getOutputDataLocations(){
        //construct input data locations.
        if(_outputDataLocations== null || _outputDataLocations.isEmpty()){
        }
        List<DataLocation> outputAsDataLoc = new ArrayList<DataLocation>();
        for(DataLocation dl : _outputDataLocations){
            outputAsDataLoc.add(dl);
        }
        return outputAsDataLoc;
    }
    public List<OutputVariable> getOutputVariables(){
        return _outputVariables;
    }
    @Override
    public String getLogFile() {
        return null;
    }
    public void setComputeOptions(ComputeOptions opts){
        _computeOptions = opts;
    }
    public boolean hasOutputVariables(){
        if (_outputVariables == null || _outputVariables.size() == 0){
            return false;
        }
        return true;
    }
    //endregion
    //region Ignored Boilerplate
    @Override
    public boolean isComputable() {
        return true;
    }
    boolean computeOutputVariables(List<OutputVariable> list) { return true; }
    @Override
    public boolean cancelCompute() {
        return false;
    }
    //endregion
    @Override
    public boolean compute() {
        String dssName;
        dssName = _computeOptions.getDssFilename();
        String databaseName = dssName.substring(0,dssName.length() - 3) + "db";
        return true;
    }


    @Override
    public boolean saveData(RmaFile file){
        if(file!=null){
        }
        return false;
    }


    @Override
    protected boolean loadDocument(org.jdom.Document dcmnt) {
        return true;
    }

//These guys are just here for testing. We wouldn't really want default input and output data locations
    public List<DataLocation> defaultInputDataLocations() {
        List<DataLocation> dlList = new ArrayList<>();
        //create datalocations for each location of interest, so that it can be linked to output from other models.
        DataLocation CoyoteEnsemble = new DataLocation(this.getModelAlt(),"Coyote.fake_forecast","flow");
        dlList.add(CoyoteEnsemble);
        return dlList;
    }



}
