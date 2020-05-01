package com.univaq.stoneage.model;

import com.univaq.stoneage.utility.TokenState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "huttoken")
public class MHutToken implements Serializable {

    @Id
    @Column(name = "id_token")
    private int idHutToken;

    @Column(name = "state")
    private TokenState m_state;

    @Transient
    private boolean m_buildableByActivePlayer;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "huttoken_resource", joinColumns = {
//            @JoinColumn(name = "STOCK_ID", nullable = false, updatable = false) },
//            inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID",
//                    nullable = false, updatable = false) })

    //
    @ElementCollection
    @CollectionTable(name = "huttoken_resource", joinColumns = @JoinColumn(name = "id_token"))
    @MapKeyJoinColumn(name = "resource_name")
    @Column(name = "quantity")
    private Map<MResource, Integer> m_resources;

    public MHutToken() {
    }

    public MHutToken(TokenState state, boolean buildable) {
        this.m_state = state;
        this.m_buildableByActivePlayer = buildable;
    }

    public TokenState getM_state() {
        return m_state;
    }

    public void setM_state(TokenState m_state) {
        this.m_state = m_state;
    }

    public boolean isM_buildableByActivePlayer() {
        return m_buildableByActivePlayer;
    }

    public void setM_buildableByActivePlayer(boolean m_buildableByActivePlayer) {
        this.m_buildableByActivePlayer = m_buildableByActivePlayer;
    }

    public int getIdHutToken() {
        return idHutToken;
    }

    public void setIdHutToken(int idHutToken) {
        this.idHutToken = idHutToken;
    }

    public Map<MResource, Integer> getM_resources() {
        return m_resources;
    }

    public void setM_resources(Map<MResource, Integer> m_resources) {
        this.m_resources = m_resources;
    }

//
//    public void getmapResource()
//    {
//        Iterator it = m_resources.entrySet().iterator();
//        while(it.hasNext())
//        {
//            it.next();
//            System.out.println("ciao");
//        }
//    }

    @PostLoad
    public void get() {
        System.out.println(this.getM_state());
    }
}
