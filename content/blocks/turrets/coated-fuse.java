{
  "type": "ItemTurret",
  "name": "coated-fuse",
  "description": "coated fuse",
  "reload": 25,
  "range": 100,
  "recoil": 1,
  "shots": 5,
  "spread": 15,
  "restitution": 0.05,
  "shootCone": 50,
  "size": 3,
  "health": "4000",
  "shootSound": "shotgun",
  "ammo": {
    "graphite": "lancerLaser" { 
      "damage": 210,
      "hitEffect": "hitLancer",
      "shootEffect": "lightningShoot",
      "smokeEffect": "lightningShoot",
      "lifetime": 11.1111,
      "despawnEffect": "none",
      "pierce": true
    }
  },
  "requirements": [
    { "item": "copper", "amount": 275 },
    { "item": "graphite", "amount": 250 },
    { "item": "iron-high-density-plate", "amount": 50 },
    { "item": "gold-high-density-plate", "amount": 50 },
    { "item": "diamond-high-density-plate", "amount": 50},
    { "item": "thorium", "amount": 135 }
  ],
  "category": "turret",
  "research": "fuse"
}
