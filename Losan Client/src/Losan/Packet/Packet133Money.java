    package Losan.Packet;

    import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

    public class Packet133Money extends Packet {//ajout

            public int playerId;
            public float money;
           
            public Packet133Money(){}
           
            public Packet133Money(EntityPlayer player){
                    this.playerId = player.entityId;
                    this.money = player.money;
            }
           
            @Override
            public void readPacketData(DataInputStream datainputstream)
                            throws IOException {
                    playerId = datainputstream.readInt();
                    money = datainputstream.readFloat();
            }

            @Override
            public void writePacketData(DataOutputStream dataoutputstream)
                            throws IOException {
                    dataoutputstream.writeInt(playerId);
                    dataoutputstream.writeFloat(money);
            }

            @Override
            public void processPacket(NetHandler nethandler) {
                    nethandler.handleMoney(this);
            }

            @Override
            public int getPacketSize() {
                    return 12;
            }
    }