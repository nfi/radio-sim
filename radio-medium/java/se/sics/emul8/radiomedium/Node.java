/*
 * Copyright (c) 2015, SICS Swedish ICT.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the Institute nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE INSTITUTE OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * \author
 *      Joakim Eriksson <joakime@sics.se> & Niclas Finne <nfi@sics.se>
 *
 */
package se.sics.emul8.radiomedium;
import se.sics.emul8.radiomedium.net.ClientConnection;

/* TODO: make the node have option to support multiple interfaces and not
 * only 802.15.4 style radio.
 */
public class Node {

    private final String id;
    private final Position pos = new Position();
    private Transciever radio;
    private Simulator sim;
    private ClientConnection clientConnection;

    public Node(String id, Simulator sim) {
        this.id = id;
        radio = new Transciever();
        this.sim = sim;
    }

    public String getId() {
        return this.id;
    }

    public Position getPosition() {
        return pos;
    }
    
    public ClientConnection getClientConnection() {
        return this.clientConnection;
    }

    public void setClientConnection(ClientConnection cc) {
        this.clientConnection = cc;
    }

    public Transciever getRadio() {
        return radio;
    }

    public void log(String logMsg) {
        /* The node produce some log message... */
        SimulationEvent event = new SimulationEvent(SimulationEvent.EventType.LOG_MESSAGE, sim.getTime(), this);
        event.setData("logMessage", logMsg);
        sim.deliverEvent(event);
    }
}
