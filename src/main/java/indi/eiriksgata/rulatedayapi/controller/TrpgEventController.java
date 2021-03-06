package indi.eiriksgata.rulatedayapi.controller;

import indi.eiriksgata.rulateday.pojo.TrpgEventSchemaEntity;
import indi.eiriksgata.rulateday.pojo.TrpgEventSchemaRelEntity;
import indi.eiriksgata.rulatedayapi.service.EventService;
import indi.eiriksgata.rulatedayapi.vo.EventContentQueryVo;
import indi.eiriksgata.rulatedayapi.vo.ResponseBean;
import indi.eiriksgata.rulatedayapi.vo.TrpgEventDataVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "事件驱动控制器")
public class TrpgEventController {

    @Autowired
    EventService eventService;

    @GetMapping("/game/event/node/first")
    public ResponseBean<?> findEventNodeFirst() {
        return ResponseBean.success(
                eventService.queryFirstNode()
        );
    }

    @PostMapping("/game/event/node/next")
    public ResponseBean<?> findEventNextNode(@RequestBody TrpgEventSchemaEntity trpgEventSchemaEntity) {
        return ResponseBean.success(
                eventService.selectNextNodes(trpgEventSchemaEntity.getId())
        );
    }

    @PostMapping("/game/event/node/info")
    public ResponseBean<?> findEventNodeInfo(@RequestBody EventContentQueryVo eventContentQueryVo) {
        return ResponseBean.success(
                eventService.selectContent(eventContentQueryVo)
        );
    }

    @PostMapping("/game/event/node")
    public ResponseBean<?> insertNode(@RequestBody TrpgEventDataVo trpgEventDataVo) {
        eventService.addNode(
                trpgEventDataVo.getTitle(),
                trpgEventDataVo.getContent(),
                trpgEventDataVo.getPreviousEventId(),
                trpgEventDataVo.isFirstNode());
        return ResponseBean.success();
    }

    @DeleteMapping("/game/event/node")
    public ResponseBean<?> deleteNode(@RequestBody TrpgEventSchemaEntity trpgEventSchemaEntity) {
        eventService.deleteNode(trpgEventSchemaEntity.getId());
        return ResponseBean.success();
    }

    @PostMapping("/game/event/node/rel")
    public ResponseBean<?> insertNodeRel(@RequestBody TrpgEventSchemaRelEntity trpgEventSchemaRelEntity) {
        eventService.addEventRel(
                trpgEventSchemaRelEntity.getEventId(),
                trpgEventSchemaRelEntity.getNextEventId()
        );
        return ResponseBean.success();
    }

    @DeleteMapping("/game/event/node/rel")
    public ResponseBean<?> deleteNodeRel(@RequestBody TrpgEventSchemaRelEntity trpgEventSchemaRelEntity) {
        eventService.deleteEventRel(trpgEventSchemaRelEntity.getEventId(), trpgEventSchemaRelEntity.getNextEventId());
        return ResponseBean.success();
    }

}
