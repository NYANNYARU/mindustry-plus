        coated_fuse = new ItemTurret("coated-fuse"){{
            requirements(research.fuse, Category.turret, ItemStack.with(Items.copper, 275, Items.graphite, 250, Items.thorium, 135, Items.iron, 250, Items.gold, 250, Items.diamond, 250));

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
