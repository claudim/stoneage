package com.univaq.stoneage.persistence.dao;

import com.univaq.stoneage.Model.MMarker;

import java.util.List;

public interface IMarkerDAO {
    void addMarker(MMarker marker);

    List<MMarker> getAllMarkers();

    void deleteMarker(String markerName);
}
