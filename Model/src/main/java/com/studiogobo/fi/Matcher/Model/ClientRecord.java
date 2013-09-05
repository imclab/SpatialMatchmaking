package com.studiogobo.fi.Matcher.Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="client")
public class ClientRecord
{
    @XmlAttribute
    public int id;

    public enum State
    {
        Matching,
        Matched,
    }

    @XmlElement
    public State state;

    public ClientRecord()
    {
        this(0);
    }

    public ClientRecord(int _id)
    {
        id = _id;
        state = State.Matching;
    }
}