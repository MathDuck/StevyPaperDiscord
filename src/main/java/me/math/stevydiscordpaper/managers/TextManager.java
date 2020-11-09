package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;

import java.util.HashMap;

public class TextManager {
    private final Main plugin;
    private final HashMap<String, String> locales;

    public TextManager(Main plugin) {
        this.plugin = plugin;
        this.locales = new HashMap<>();
    }

    public void init() {
        this.locales.clear();
        loadStrings();
    }

    private void loadStrings() {
        this.locales.put("advancements.adventure.adventuring_time.description", "Découvrez tous les biomes.");
        this.locales.put("advancements.adventure.adventuring_time.title", "Partons à l'aventure !");
        this.locales.put("advancements.adventure.arbalistic.description", "Tuez cinq créatures de types différents d'un tir d'arbalète.");
        this.locales.put("advancements.adventure.arbalistic.title", "Arbalistique");
        this.locales.put("advancements.adventure.bullseye.description", "Touchez le centre d'une cible à au moins 30 mètres de distance.");
        this.locales.put("advancements.adventure.bullseye.title", "Dans le mille !");
        this.locales.put("advancements.adventure.hero_of_the_village.description", "Protégez un village d'une invasion.");
        this.locales.put("advancements.adventure.hero_of_the_village.title", "Héros du village");
        this.locales.put("advancements.adventure.honey_block_slide.description", "Sautez contre un bloc de miel pour ralentir votre chute.");
        this.locales.put("advancements.adventure.honey_block_slide.title", "Atterrissage en douceur");
        this.locales.put("advancements.adventure.kill_a_mob.description", "Tuez n'importe quelle créature hostile.");
        this.locales.put("advancements.adventure.kill_a_mob.title", "Chasseur de monstres");
        this.locales.put("advancements.adventure.kill_all_mobs.description", "Tuez au moins une fois chaque créature hostile.");
        this.locales.put("advancements.adventure.kill_all_mobs.title", "Monstres chassés");
        this.locales.put("advancements.adventure.ol_betsy.description", "Tirez à l'arbalète.");
        this.locales.put("advancements.adventure.ol_betsy.title", "Ma vieille Bertha");
        this.locales.put("advancements.adventure.root.description", "Aventure, exploration et combat");
        this.locales.put("advancements.adventure.root.title", "Aventure");
        this.locales.put("advancements.adventure.shoot_arrow.description", "Tirez sur quelque chose avec une flèche.");
        this.locales.put("advancements.adventure.shoot_arrow.title", "Dans la ligne de mire");
        this.locales.put("advancements.adventure.sleep_in_bed.description", "Dormez dans un lit pour changer votre point de réapparition.");
        this.locales.put("advancements.adventure.sleep_in_bed.title", "Faites de beaux rêves");
        this.locales.put("advancements.adventure.sniper_duel.description", "Tuez un squelette à au moins 50 mètres de distance.");
        this.locales.put("advancements.adventure.sniper_duel.title", "Duel de snipers");
        this.locales.put("advancements.adventure.summon_iron_golem.description", "Invoquez un golem de fer pour défendre un village.");
        this.locales.put("advancements.adventure.summon_iron_golem.title", "Agent de sécurité");
        this.locales.put("advancements.adventure.throw_trident.description", "Lancez un trident sur quelque chose.\nRemarque : lancer votre seule arme n'est pas une bonne idée.");
        this.locales.put("advancements.adventure.throw_trident.title", "Une blague tombée à l'eau");
        this.locales.put("advancements.adventure.totem_of_undying.description", "Utilisez un totem d'immortalité pour tromper la mort.");
        this.locales.put("advancements.adventure.totem_of_undying.title", "Aux frontières de la mort");
        this.locales.put("advancements.adventure.trade.description", "Commercez avec un villageois.");
        this.locales.put("advancements.adventure.trade.title", "Adjugé, vendu !");
        this.locales.put("advancements.adventure.two_birds_one_arrow.description", "Tuez deux Phantoms avec une flèche perforante.");
        this.locales.put("advancements.adventure.two_birds_one_arrow.title", "D'une flèche deux coups");
        this.locales.put("advancements.adventure.very_very_frightening.description", "Frappez un villageois avec la foudre.");
        this.locales.put("advancements.adventure.very_very_frightening.title", "Coup de foudre");
        this.locales.put("advancements.adventure.voluntary_exile.description", "Tuez un capitaine de pillards.\nEnvisagez peut-être de rester à l'écart des villages pour le moment...");
        this.locales.put("advancements.adventure.voluntary_exile.title", "Exil volontaire");
        this.locales.put("advancements.adventure.whos_the_pillager_now.description", "Rendez à un pillard la monnaie de sa pièce.");
        this.locales.put("advancements.adventure.whos_the_pillager_now.title", "C'est qui le pillard maintenant ?");
        this.locales.put("advancements.empty", "Il semble qu'il n'y a pas grand-chose ici...");
        this.locales.put("advancements.end.dragon_breath.description", "Récupérez du souffle de dragon dans une fiole.");
        this.locales.put("advancements.end.dragon_breath.title", "À bout de souffle");
        this.locales.put("advancements.end.dragon_egg.description", "Tenez l'œuf de dragon.");
        this.locales.put("advancements.end.dragon_egg.title", "La nouvelle génération");
        this.locales.put("advancements.end.elytra.description", "Trouvez des élytres.");
        this.locales.put("advancements.end.elytra.title", "Vers l'infini et au-delà");
        this.locales.put("advancements.end.enter_end_gateway.description", "Échappez-vous de l'île.");
        this.locales.put("advancements.end.enter_end_gateway.title", "Escapade à distance");
        this.locales.put("advancements.end.find_end_city.description", "Allez-y, que pourrait-il vous arriver ?");
        this.locales.put("advancements.end.find_end_city.title", "La cité du bout du monde");
        this.locales.put("advancements.end.kill_dragon.description", "Tuez le dragon. Bonne chance !");
        this.locales.put("advancements.end.kill_dragon.title", "Libérez l'End !");
        this.locales.put("advancements.end.levitate.description", "Lévitez à 50 blocs de hauteur après l'attaque d'un Shulker.");
        this.locales.put("advancements.end.levitate.title", "Superbe panorama");
        this.locales.put("advancements.end.respawn_dragon.description", "Faites réapparaître l'Ender Dragon.");
        this.locales.put("advancements.end.respawn_dragon.title", "Un air de déjà vu...");
        this.locales.put("advancements.end.root.description", "Est-ce vraiment la fin ?");
        this.locales.put("advancements.end.root.title", "L'End");
        this.locales.put("advancements.husbandry.balanced_diet.description", "Mangez tout ce qui est comestible, même si ce n'est pas bon pour vous.");
        this.locales.put("advancements.husbandry.balanced_diet.title", "Une alimentation équilibrée");
        this.locales.put("advancements.husbandry.breed_all_animals.description", "Faites se reproduire au moins une fois chaque animal.");
        this.locales.put("advancements.husbandry.breed_all_animals.title", "Deux par deux");
        this.locales.put("advancements.husbandry.breed_an_animal.description", "Faites se reproduire deux animaux ensemble.");
        this.locales.put("advancements.husbandry.breed_an_animal.title", "Il y a de l'amour dans l'air");
        this.locales.put("advancements.husbandry.complete_catalogue.description", "Apprivoisez toutes les variantes de chat !");
        this.locales.put("advancements.husbandry.complete_catalogue.title", "Un chatalogue complet");
        this.locales.put("advancements.husbandry.fishy_business.description", "Pêchez un poisson.");
        this.locales.put("advancements.husbandry.fishy_business.title", "Merci pour le poisson");
        this.locales.put("advancements.husbandry.netherite_hoe.description", "Utilisez un lingot de Netherite pour améliorer une houe, puis réévaluez vos choix de vie.");
        this.locales.put("advancements.husbandry.netherite_hoe.title", "Sérieux dévouement");
        this.locales.put("advancements.husbandry.plant_seed.description", "Plantez une graine et regardez-la grandir.");
        this.locales.put("advancements.husbandry.plant_seed.title", "Prends-en de la graine !");
        this.locales.put("advancements.husbandry.root.description", "Le monde est plein d'amis et de nourriture");
        this.locales.put("advancements.husbandry.root.title", "Agriculture");
        this.locales.put("advancements.husbandry.safely_harvest_honey.description", "Utilisez un feu de camp pour récolter avec une fiole le miel d'une ruche sans provoquer les abeilles.");
        this.locales.put("advancements.husbandry.safely_harvest_honey.title", "J'irai butiner chez vous");
        this.locales.put("advancements.husbandry.silk_touch_nest.description", "Déplacez un nid d'abeilles avec 3 abeilles à l'intérieur en utilisant Toucher de soie.");
        this.locales.put("advancements.husbandry.silk_touch_nest.title", "Dé-miel-nagement");
        this.locales.put("advancements.husbandry.tactical_fishing.description", "Attrapez un poisson... sans canne à pêche !");
        this.locales.put("advancements.husbandry.tactical_fishing.title", "Pêche tactique");
        this.locales.put("advancements.husbandry.tame_an_animal.description", "Apprivoisez un animal.");
        this.locales.put("advancements.husbandry.tame_an_animal.title", "Meilleurs amis pour la vie");
        this.locales.put("advancements.nether.all_effects.description", "Appliquez sur vous-même tous les effets en même temps.");
        this.locales.put("advancements.nether.all_effects.title", "Comment en est-on arrivé là ?");
        this.locales.put("advancements.nether.all_potions.description", "Appliquez sur vous-même tous les effets de potions en même temps.");
        this.locales.put("advancements.nether.all_potions.title", "Mélanges dangereux");
        this.locales.put("advancements.nether.brew_potion.description", "Concoctez une potion.");
        this.locales.put("advancements.nether.brew_potion.title", "Apprenti chimiste");
        this.locales.put("advancements.nether.charge_respawn_anchor.description", "Chargez une ancre de réapparition à son maximum.");
        this.locales.put("advancements.nether.charge_respawn_anchor.title", "Pas tout à fait \"neuf\" vies");
        this.locales.put("advancements.nether.create_beacon.description", "Construisez et placez une balise.");
        this.locales.put("advancements.nether.create_beacon.title", "Fais ta balise");
        this.locales.put("advancements.nether.create_full_beacon.description", "Créez une balise complète.");
        this.locales.put("advancements.nether.create_full_beacon.title", "Phare à On");
        this.locales.put("advancements.nether.distract_piglin.description", "Distrayez un Piglin avec de l'or.");
        this.locales.put("advancements.nether.distract_piglin.title", "Bling-bling");
        this.locales.put("advancements.nether.explore_nether.description", "Explorez tous les biomes du Nether.");
        this.locales.put("advancements.nether.explore_nether.title", "Voyage au bout de l'enfer");
        this.locales.put("advancements.nether.fast_travel.description", "Utilisez le Nether pour parcourir 7 kilomètres à la Surface.");
        this.locales.put("advancements.nether.fast_travel.title", "Bulle du sous-espace");
        this.locales.put("advancements.nether.find_bastion.description", "Entrez dans les vestiges d'un bastion.");
        this.locales.put("advancements.nether.find_bastion.title", "Le bon vieux temps");
        this.locales.put("advancements.nether.find_fortress.description", "Découvrez une forteresse du Nether.");
        this.locales.put("advancements.nether.find_fortress.title", "Une terrible forteresse");
        this.locales.put("advancements.nether.get_wither_skull.description", "Obtenez un crâne de Wither squelette.");
        this.locales.put("advancements.nether.get_wither_skull.title", "Squelette fantasmagorique");
        this.locales.put("advancements.nether.loot_bastion.description", "Pillez un coffre dans les vestiges d'un bastion.");
        this.locales.put("advancements.nether.loot_bastion.title", "De vraies têtes de cochon");
        this.locales.put("advancements.nether.netherite_armor.description", "Obtenez une armure complète en Netherite.");
        this.locales.put("advancements.nether.netherite_armor.title", "Couvrez-moi de débris");
        this.locales.put("advancements.nether.obtain_ancient_debris.description", "Obtenez des débris antiques.");
        this.locales.put("advancements.nether.obtain_ancient_debris.title", "Caché dans les profondeurs");
        this.locales.put("advancements.nether.obtain_blaze_rod.description", "Récupérez un bâton de Blaze.");
        this.locales.put("advancements.nether.obtain_blaze_rod.title", "Dans le feu de l'action");
        this.locales.put("advancements.nether.obtain_crying_obsidian.description", "Obtenez un bloc d'obsidienne pleureuse.");
        this.locales.put("advancements.nether.obtain_crying_obsidian.title", "Qui a coupé un oignon ?");
        this.locales.put("advancements.nether.return_to_sender.description", "Détruisez un Ghast avec une boule de feu.");
        this.locales.put("advancements.nether.return_to_sender.title", "Retour à l'envoyeur");
        this.locales.put("advancements.nether.ride_strider.description", "Chevauchez et dirigez un arpenteur avec un champignon biscornu sur un bâton.");
        this.locales.put("advancements.nether.ride_strider.title", "Bateau sur pattes");
        this.locales.put("advancements.nether.root.description", "Bienvenue en enfer");
        this.locales.put("advancements.nether.root.title", "Nether");
        this.locales.put("advancements.nether.summon_wither.description", "Invoquez le Wither.");
        this.locales.put("advancements.nether.summon_wither.title", "Les Witherables");
        this.locales.put("advancements.nether.uneasy_alliance.description", "Sauvez un Ghast du Nether, amenez-le en toute sécurité à la Surface... et puis tuez-le.");
        this.locales.put("advancements.nether.uneasy_alliance.title", "Alliance instable");
        this.locales.put("advancements.nether.use_lodestone.description", "Utilisez une boussole sur un bloc de magnétite.");
        this.locales.put("advancements.nether.use_lodestone.title", "Le Petit Poucet");
        this.locales.put("advancements.sad_label", ":(");
        this.locales.put("advancements.story.cure_zombie_villager.description", "Affaiblissez et soignez un zombie-villageois.");
        this.locales.put("advancements.story.cure_zombie_villager.title", "Zombiologue");
        this.locales.put("advancements.story.deflect_arrow.description", "Parez un projectile avec un bouclier.");
        this.locales.put("advancements.story.deflect_arrow.title", "Pas aujourd'hui, merci");
        this.locales.put("advancements.story.enchant_item.description", "Enchantez un objet dans la table d'enchantement.");
        this.locales.put("advancements.story.enchant_item.title", "Enchanté !");
        this.locales.put("advancements.story.enter_the_end.description", "Entrez dans le portail de l'End.");
        this.locales.put("advancements.story.enter_the_end.title", "Fin ?");
        this.locales.put("advancements.story.enter_the_nether.description", "Construisez, allumez et entrez dans un portail du Nether.");
        this.locales.put("advancements.story.enter_the_nether.title", "Aller au fond des choses");
        this.locales.put("advancements.story.follow_ender_eye.description", "Suivez un œil de l'Ender.");
        this.locales.put("advancements.story.follow_ender_eye.title", "À suivre…");
        this.locales.put("advancements.story.form_obsidian.description", "Obtenez un bloc d'obsidienne.");
        this.locales.put("advancements.story.form_obsidian.title", "Ice Bucket Challenge");
        this.locales.put("advancements.story.iron_tools.description", "Fabriquez une pioche en fer.");
        this.locales.put("advancements.story.iron_tools.title", "Bonne pioche !");
        this.locales.put("advancements.story.lava_bucket.description", "Remplissez un seau de lave.");
        this.locales.put("advancements.story.lava_bucket.title", "Ça brûle !");
        this.locales.put("advancements.story.mine_diamond.description", "Obtenez des diamants.");
        this.locales.put("advancements.story.mine_diamond.title", "Des diamants !");
        this.locales.put("advancements.story.mine_stone.description", "Minez de la roche avec votre nouvelle pioche.");
        this.locales.put("advancements.story.mine_stone.title", "L'âge de pierre");
        this.locales.put("advancements.story.obtain_armor.description", "Fabriquez une pièce d'armure en fer.");
        this.locales.put("advancements.story.obtain_armor.title", "Un corps d'acier");
        this.locales.put("advancements.story.root.description", "Le cœur et l'histoire du jeu");
        this.locales.put("advancements.story.root.title", "Minecraft");
        this.locales.put("advancements.story.shiny_gear.description", "Une armure en diamant peut sauver la vie.");
        this.locales.put("advancements.story.shiny_gear.title", "Couvrez-moi de diamants");
        this.locales.put("advancements.story.smelt_iron.description", "Faites fondre du fer.");
        this.locales.put("advancements.story.smelt_iron.title", "L'âge du fer");
        this.locales.put("advancements.story.upgrade_tools.description", "Fabriquez une meilleure pioche.");
        this.locales.put("advancements.story.upgrade_tools.title", "Qualité supérieure");
    }

    public void dispose() {
        this.locales.clear();
    }

    public String getTextData(String key) {
        if (this.locales.containsKey(key))
            return this.locales.get(key);

        return "";
    }
}
