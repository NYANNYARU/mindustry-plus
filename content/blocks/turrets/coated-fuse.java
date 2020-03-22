package mindustry.content;

import arc.*;
import arc.struct.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.type.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.modules.*;

public class Blocks implements ContentList{
    public static Block

    //environment
    air, spawn, deepwater, water, taintedWater, tar, stone, craters, charr, sand, darksand, ice, snow, darksandTaintedWater,
    holostone, rocks, sporerocks, icerocks, cliffs, sporePine, snowPine, pine, shrubs, whiteTree, whiteTreeDead, sporeCluster,
    iceSnow, sandWater, darksandWater, duneRocks, sandRocks, moss, sporeMoss, shale, shaleRocks, shaleBoulder, sandBoulder, grass, salt,
    metalFloor, metalFloorDamaged, metalFloor2, metalFloor3, metalFloor5, ignarock, magmarock, hotrock, snowrocks, rock, snowrock, saltRocks,
    darkPanel1, darkPanel2, darkPanel3, darkPanel4, darkPanel5, darkPanel6, darkMetal,
    pebbles, tendrils,

    //ores
    oreCopper, oreLead, oreScrap, oreCoal, oreTitanium, oreThorium,

    //crafting
    siliconSmelter, kiln, graphitePress, plastaniumCompressor, multiPress, phaseWeaver, surgeSmelter, pyratiteMixer, blastMixer, cryofluidMixer,
    melter, separator, sporePress, pulverizer, incinerator, coalCentrifuge,

    //sandbox
    powerSource, powerVoid, itemSource, itemVoid, liquidSource, liquidVoid, message, illuminator,

    //defense
    copperWall, copperWallLarge, titaniumWall, titaniumWallLarge, plastaniumWall, plastaniumWallLarge, thoriumWall, thoriumWallLarge, door, doorLarge,
    phaseWall, phaseWallLarge, surgeWall, surgeWallLarge, mender, mendProjector, overdriveProjector, forceProjector, shockMine,
    scrapWall, scrapWallLarge, scrapWallHuge, scrapWallGigantic, thruster, //ok, these names are getting ridiculous, but at least I don't have humongous walls yet

    //transport
    conveyor, titaniumConveyor, armoredConveyor, distributor, junction, itemBridge, phaseConveyor, sorter, invertedSorter, router, overflowGate, underflowGate, massDriver,

    //liquid
    mechanicalPump, rotaryPump, thermalPump, conduit, pulseConduit, platedConduit, liquidRouter, liquidTank, liquidJunction, bridgeConduit, phaseConduit,

    //power
    combustionGenerator, thermalGenerator, turbineGenerator, differentialGenerator, rtgGenerator, solarPanel, largeSolarPanel, thoriumReactor,
    impactReactor, battery, batteryLarge, powerNode, powerNodeLarge, surgeTower, diode,

    //production
    mechanicalDrill, pneumaticDrill, laserDrill, blastDrill, waterExtractor, oilExtractor, cultivator,

    //storage
    coreShard, coreFoundation, coreNucleus, vault, container, unloader, launchPad, launchPadLarge,

    //turrets
    duo, scatter, scorch, hail, arc, wave, lancer, swarmer, salvo, fuse, ripple, cyclone, spectre, meltdown,

    //units
    commandCenter, draugFactory, spiritFactory, phantomFactory, wraithFactory, ghoulFactory, revenantFactory, daggerFactory, crawlerFactory, titanFactory,
    fortressFactory, repairPoint,

    //upgrades
    dartPad, deltaPad, tauPad, omegaPad, javelinPad, tridentPad, glaivePad;
            
coated_fuse = new ItemTurret("coated-fuse"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 275, Items.graphite, 250, Items.thorium, 135, Items.iron, 250, Items.gold, 250, Items.diamond, 250));

            reload = 25f;
            shootShake = 2f;
            range = 100f;
            recoil = 2.5f;
            shots = 5;
            spread = 15f;
            restitution = 0.05f;
            shootCone = 50;
            size = 3;

            health = 4000;
            shootSound = Sounds.shotgun;

            ammo(Items.graphite, new BulletType(0.01f, 105){
                int rays = 1;
                float rayLength = range + 10f;

                {
                    hitEffect = Fx.hitLancer;
                    shootEffect = smokeEffect = Fx.lightningShoot;
                    lifetime = 10f;
                    despawnEffect = Fx.none;
                    pierce = true;
                }

                @Override
                public void init(mindustry.entities.type.Bullet b){
                    for(int i = 0; i < rays; i++){
                        Damage.collideLine(b, b.getTeam(), hitEffect, b.x, b.y, b.rot(), rayLength - Math.abs(i - (rays / 2)) * 40f);
                    }
                }

                @Override
                public void draw(Bullet b){
                    super.draw(b);
                    Draw.color(Color.white, Pal.lancerLaser, b.fin());
                    //Draw.alpha(b.fout());
                    for(int i = 0; i < 7; i++){
                        Tmp.v1.trns(b.rot(), i * 8f);
                        float sl = Mathf.clamp(b.fout() - 0.5f) * (80f - i * 10);
                        Drawf.tri(b.x + Tmp.v1.x, b.y + Tmp.v1.y, 4f, sl, b.rot() + 90);
                        Drawf.tri(b.x + Tmp.v1.x, b.y + Tmp.v1.y, 4f, sl, b.rot() - 90);
                    }
                    Drawf.tri(b.x, b.y, 20f * b.fout(), (rayLength + 50), b.rot());
                    Drawf.tri(b.x, b.y, 20f * b.fout(), 10f, b.rot() + 180f);
                    Draw.reset();
                }
            });
        }};
