/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newyork.taxi;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class ProcessedTaxiTrip implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Map<String,Integer> resultMap;    
    private List<GreenTrip> queryResult;
    

    public ProcessedTaxiTrip() {
    }
    
    public ProcessedTaxiTrip(List<GreenTrip> queryResult) {
        this.queryResult = queryResult;
        this.resultMap= new TreeMap<String,Integer>();
        process();
    }
    
    public Map<String, Integer> getResultMap() {
        return resultMap; 
    }
    
    public void setResultMap(Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }
    
    private void process() {
        Iterator iterator = queryResult.iterator();
        GreenTrip greenTrip;
        while(iterator.hasNext()) {
            greenTrip = (GreenTrip) iterator.next();
            String resultKey = greenTrip.getLpepPickupDatetime().toString();
            resultKey = resultKey.substring(0, resultKey.length() - 4) + "00";
            
            Integer resultValue = resultMap.get(resultKey) != null ? resultMap.get(resultKey) + 1 : 1;
            resultMap.put(resultKey,resultValue);                  
        }
    }
    
}
