   package Losan.Packet;

    import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

    

    public class Packet135Droit extends Packet {//ajout

            public String name;
            public boolean cond;
            
            public Packet135Droit(){}
           
            public Packet135Droit(EntityPlayer p){
                    this.name = p.username;
                    this.cond = false;
            }
           
            @Override
            public void readPacketData(DataInputStream datainputstream)
                            throws IOException {
                    name = datainputstream.readUTF();
                    cond = datainputstream.readBoolean();
            }

            @Override
            public void writePacketData(DataOutputStream dataoutputstream)
                            throws IOException {
                    dataoutputstream.writeUTF(name);
                    dataoutputstream.writeBoolean(cond);
                    
            }

            @Override
            public void processPacket(NetHandler nethandler) {
                    nethandler.handleDroit(this);
            }

            @Override
            public int getPacketSize() {
                    return 32;
            }
    }