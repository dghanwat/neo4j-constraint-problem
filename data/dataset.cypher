MERGE (s1:InitialState:State{attribute:"FWGC_"})
MERGE (s2:State{attribute:"GC_FW"})
MERGE (s3:State{attribute:"WC_FG"})
MERGE (s4:State{attribute:"WG_FC"})

MERGE (s1)-[:takes_wolf]->(s2)
MERGE (s1)-[:takes_goat]->(s3)
MERGE (s1)-[:takes_carrots]->(s4)
MERGE (s3)-[:returns_goat]->(s1)
MERGE (s2)-[:returns_wolf]->(s1)
MERGE (s4)-[:returns_carrots]->(s1)



MERGE (s5:State{attribute:"FGC_W"})
MERGE (s6:State{attribute:"FWGC_"})
MERGE (s2)-[:returns_empty]->(s5)
MERGE (s2)-[:returns_wolf]->(s6)


MERGE (s7:State{attribute:"FWC_G"})
MERGE (s8:State{attribute:"FWGC_"})
MERGE (s3)-[:returns_empty]->(s7)
MERGE (s3)-[:returns_goat]->(s8)

MERGE (s9:State{attribute:"FWG_C"})
MERGE (s10:State{attribute:"FWGC_"})
MERGE (s4)-[:returns_empty]->(s9)
MERGE (s4)-[:returns_carrots]->(s10)

MERGE (s51:State{attribute:"C_FWG"})
MERGE (s52:State{attribute:"G_FWC"})
MERGE (s5)-[:takes_goat]->(s51)
MERGE (s5)-[:takes_carrots]->(s52)


MERGE (s71:State{attribute:"C_FWG"})
MERGE (s72:State{attribute:"W_FGC"})
MERGE (s7)-[:takes_wolf]->(s71)
MERGE (s7)-[:takes_carrots]->(s72)

MERGE (s91:State{attribute:"G_FWC"})
MERGE (s92:State{attribute:"W_FGC"})
MERGE (s9)-[:takes_wolf]->(s91)
MERGE (s9)-[:takes_goat]->(s92)

MERGE (s511:State{attribute:"FWC_G"})
MERGE (s512:State{attribute:"FGC_W"})
MERGE (s513:State{attribute:"FC_WG"})

MERGE (s51)-[:takes_wolf]->(s511)
MERGE (s51)-[:takes_goat]->(s512)
MERGE (s51)-[:returns_empty]->(s513)


MERGE (s521:State{attribute:"FWG_C"})
MERGE (s522:State{attribute:"FGC_W"})
MERGE (s523:State{attribute:"FG_WC"})
MERGE (s52)-[:takes_wolf]->(s521)
MERGE (s52)-[:takes_carrots]->(s522)
MERGE (s52)-[:returns_empty]->(s523)

MERGE (s711:State{attribute:"FGC_W"})
MERGE (s712:State{attribute:"FWC_G"})
MERGE (s713:State{attribute:"FC_WG"})
MERGE (s71)-[:takes_goat]->(s711)
MERGE (s71)-[:takes_wolf]->(s712)
MERGE (s71)-[:returns_empty]->(s713)



MERGE (s721:State{attribute:"FW_GC"})
MERGE (s722:State{attribute:"FWG_C"})
MERGE (s723:State{attribute:"FWC_G"})
MERGE (s72)-[:returns_empty]->(s721)
MERGE (s72)-[:takes_goat]->(s722)
MERGE (s72)-[:takes_carrots]->(s723)


MERGE (s911:State{attribute:"FG_WC"})
MERGE (s912:State{attribute:"FWG_C"})
MERGE (s913:State{attribute:"FGC_W"})

MERGE (s91)-[:returns_empty]->(s911)
MERGE (s91)-[:takes_wolf]->(s912)
MERGE (s91)-[:takes_carrots]->(s913)


MERGE (s921:State{attribute:"FW_GC"})
MERGE (s922:State{attribute:"FWG_C"})
MERGE (s923:State{attribute:"FWC_G"})
MERGE (s92)-[:returns_empty]->(s921)
MERGE (s92)-[:takes_goat]->(s922)
MERGE (s92)-[:takes_carrots]->(s923)


MERGE (s5131:FinalState:State{attribute:"_FWGC"})
MERGE (s5231:FinalState:State{attribute:"_FWGC"})
MERGE (s7131:FinalState:State{attribute:"_FWGC"})
MERGE (s7211:FinalState:State{attribute:"_FWGC"})
MERGE (s9111:FinalState:State{attribute:"_FWGC"})
MERGE (s9211:FinalState:State{attribute:"_FWGC"})

MERGE (s513)-[:takes_carrots]->(s5131)
MERGE (s523)-[:takes_goat]->(s5231)
MERGE (s713)-[:takes_carrots]->(s7131)
MERGE (s721)-[:takes_wolf]->(s7211)
MERGE (s911)-[:takes_goat]->(s9111)
MERGE (s921)-[:takes_wolf]->(s9211)

